package com.azilen.adal;

import javax.servlet.http.HttpServletRequest;

import com.microsoft.aad.adal4j.AuthenticationResult;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationSuccessResponse;

/**
 * CommonUtil: Utility class
 * 
 * @author vijay kareliya
 *
 */
public final class CommonUtil {

	public static final String PRINCIPAL_SESSION_NAME = "principal";
	public static String ERROR = "error";
	public static String ERROR_DESCRIPTION = "error_description";
	public static String ERROR_URI = "error_uri";
	public static String ID_TOKEN = "id_token";
	public static String CODE = "code";

	private CommonUtil() {
	}

	public static boolean isAuthenticated(HttpServletRequest request) {
		return request.getSession().getAttribute(PRINCIPAL_SESSION_NAME) != null;
	}

	public static AuthenticationResult getAuthSessionObject(HttpServletRequest request) {
		return (AuthenticationResult) request.getSession().getAttribute(PRINCIPAL_SESSION_NAME);
	}

	public static boolean containsAuthenticationData(HttpServletRequest httpRequest) {
		return (httpRequest.getMethod().equalsIgnoreCase("POST") || httpRequest.getMethod().equalsIgnoreCase("GET"))
				&& (httpRequest.getParameterMap().containsKey(ERROR) || httpRequest.getParameterMap().containsKey(ID_TOKEN)
						|| httpRequest.getParameterMap().containsKey(CODE));
	}

	public static boolean isAuthenticationSuccessful(AuthenticationResponse authResponse) {
		return authResponse instanceof AuthenticationSuccessResponse;
	}
}
