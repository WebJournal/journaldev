package com.azilen.adal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.ServiceUnavailableException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;
import com.nimbusds.oauth2.sdk.AuthorizationCode;
import com.nimbusds.openid.connect.sdk.AuthenticationErrorResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationResponseParser;
import com.nimbusds.openid.connect.sdk.AuthenticationSuccessResponse;

public class AdalFilter implements Filter {

	public static final String STATES = "states";
	private String clientId = "";
	private String clientSecret = "";
	private String tenant = "";
	private String authority;
	private String replyURL;
	public static final String PRINCIPAL_SESSION_NAME = "principal";
		
	Log log = LogFactory.getLog(AdalFilter.class);

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			try {

				String currentUri = replyURL;
				String fullUrl = currentUri + (httpRequest.getQueryString() != null ? "?" + httpRequest.getQueryString() : "");
				// check if user has a session
				log.debug("AuthHelper.isAuthenticated(httpRequest):  " + CommonUtil.isAuthenticated(httpRequest));

				if (!CommonUtil.isAuthenticated(httpRequest)) {
					if (CommonUtil.containsAuthenticationData(httpRequest)) {
						Map<String, String> params = new HashMap<String, String>();
						for (String key : request.getParameterMap().keySet()) {
							log.debug(key + ":" + request.getParameterMap().get(key)[0]);
							params.put(key, request.getParameterMap().get(key)[0]);
						}
						AuthenticationResponse authResponse = AuthenticationResponseParser.parse(new URI(fullUrl), params);
						log.debug("authResponse: " + authResponse);
						log.debug("isAuthenticated: " + CommonUtil.isAuthenticationSuccessful(authResponse));

						if (CommonUtil.isAuthenticationSuccessful(authResponse)) {

							AuthenticationSuccessResponse oidcResponse = (AuthenticationSuccessResponse) authResponse;

							log.debug("getAccessToken will be called now");
							AuthenticationResult result = getAccessToken(oidcResponse.getAuthorizationCode(), currentUri);
							createSessionPrincipal(httpRequest, result);
						} else {

							AuthenticationErrorResponse oidcResponse = (AuthenticationErrorResponse) authResponse;
							log.debug(String.format("Request for auth code failed: %s - %s", oidcResponse.getErrorObject().getCode(),
									oidcResponse.getErrorObject().getDescription()));
							throw new Exception(String.format("Request for auth code failed: %s - %s", oidcResponse.getErrorObject().getCode(),
									oidcResponse.getErrorObject().getDescription()));
						}
					} else {
						log.debug("not authenticated");
						// not authenticated
						httpResponse.setStatus(302);
						// use state parameter to validate response from
						// Authorization server
						String state = UUID.randomUUID().toString();

						// use nonce parameter to validate idToken
						String nonce = UUID.randomUUID().toString();

						storeStateInSession(httpRequest.getSession(), state, nonce);

						httpResponse.sendRedirect(getRedirectUrl(currentUri, httpRequest.getParameter("claims"), state, nonce));
						return;
					}
				} else {
					// if authenticated, how to check for valid session?
					AuthenticationResult result = CommonUtil.getAuthSessionObject(httpRequest);

					result = getAccessTokenFromClientCredentials();
					createSessionPrincipal(httpRequest, result);
				}
			} catch (Throwable exc) {
				exc.printStackTrace();
				log.debug("exception : " + exc.getMessage());
				httpResponse.setStatus(500);
				request.setAttribute("error", exc.getMessage());
				httpResponse.sendRedirect(((HttpServletRequest) request).getContextPath() + "/error.jsp");
			}
		}
		chain.doFilter(request, response);

	}

	@SuppressWarnings("unchecked")
	private void storeStateInSession(HttpSession session, String state, String nonce) {
		if (session.getAttribute(STATES) == null) {
			session.setAttribute(STATES, new HashMap<String, StateData>());
		}
		((Map<String, StateData>) session.getAttribute(STATES)).put(state, new StateData(nonce, new Date()));
	}

	private AuthenticationResult getAccessTokenFromClientCredentials() throws Throwable {
		AuthenticationContext context = null;
		AuthenticationResult result = null;
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(1);
			context = new AuthenticationContext(authority + tenant + "/", true, service);
			Future<AuthenticationResult> future = context.acquireToken("https://graph.windows.net", new ClientCredential(clientId, clientSecret),
					null);
			result = future.get();
		} catch (Exception e) {
			log.debug("ExecutionException in getAccessTokenFromClientCredentials");
			e.printStackTrace();
			throw e.getCause();
		} finally {
			service.shutdown();
		}

		if (result == null) {
			log.debug("result is null in getAccessTokenFromClientCredentials");
			throw new ServiceUnavailableException("authentication result was null");
		}
		return result;
	}

	private AuthenticationResult getAccessToken(AuthorizationCode authorizationCode, String currentUri) throws Throwable {
		String authCode = authorizationCode.getValue();
		AuthenticationContext context = null;
		AuthenticationResult result = null;
		ExecutorService service = null;
		log.debug("getAccessToken : enter : " + currentUri + " : " + clientId);

		/* Resolution for PKIX error */
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		try {
			service = Executors.newFixedThreadPool(1);
			context = new AuthenticationContext(authority + tenant + "/", false, service);

			Future<AuthenticationResult> future = context.acquireTokenByAuthorizationCode(authCode, currentUri, clientId, URI.create(currentUri),
					null);
			result = future.get();
		} catch (Exception e) {
			log.debug("getAccessToken : " + e.getMessage());
			e.printStackTrace();
			throw e.getCause();
		} finally {
			service.shutdown();
		}

		if (result == null) {
			log.debug("getAccessToken result null");
			throw new ServiceUnavailableException("authentication result was null");
		}
		return result;
	}

	private void createSessionPrincipal(HttpServletRequest httpRequest, AuthenticationResult result) throws Exception {
		httpRequest.getSession().setAttribute(CommonUtil.PRINCIPAL_SESSION_NAME, result);
	}

	private String getRedirectUrl(String currentUri, String claims, String state, String nonce) throws UnsupportedEncodingException {
		String redirectUrl = authority + this.tenant + "/oauth2/authorize?" + "response_type=code&" + "response_mode=form_post&" + "redirect_uri="
				+ URLEncoder.encode(currentUri, "UTF-8") + "&client_id=" + URLEncoder.encode(clientId, "UTF-8")
				+ (StringUtils.isEmpty(claims) ? "" : "&claims=" + claims) + "&state=" + state + "&nonce=" + nonce;

		return redirectUrl;
	}

	public void init(FilterConfig config) throws ServletException {
		clientId = config.getInitParameter("client_id");
		authority = config.getServletContext().getInitParameter("authority");
		tenant = config.getServletContext().getInitParameter("tenant");
		clientSecret = config.getInitParameter("secret_key");
		replyURL = config.getInitParameter("replyURL");
	}

	private class StateData {
		private String nonce;
		private Date expirationDate;

		public StateData(String nonce, Date expirationDate) {
			this.nonce = nonce;
			this.expirationDate = expirationDate;
		}

		public String getNonce() {
			return nonce;
		}

		public Date getExpirationDate() {
			return expirationDate;
		}
	}

}
