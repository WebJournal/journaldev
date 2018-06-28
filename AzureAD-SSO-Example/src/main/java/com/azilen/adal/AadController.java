package com.azilen.adal;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microsoft.aad.adal4j.AuthenticationResult;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;

@Controller
@RequestMapping("/secure/aad")
public class AadController {

	Log log = LogFactory.getLog(AadController.class);

	/**
	 * getScurePage: Will check for JWT token details and returns aad.jsp view
	 * @param model
	 * @param httpRequest
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String getScurePage(ModelMap model, HttpServletRequest httpRequest) {
		HttpSession session = httpRequest.getSession();
		log.debug("session: " + session);
		AuthenticationResult result = (AuthenticationResult) session.getAttribute(CommonUtil.PRINCIPAL_SESSION_NAME);
		if (result == null) {
			model.addAttribute("error", new Exception("AuthenticationResult not found in session."));
			return "/error";
		} else {
			try {
				log.debug("JWT token details:-");
				JWT jwt = JWTParser.parse(result.getIdToken());
				for (String key : jwt.getJWTClaimsSet().getAllClaims().keySet()) {
					log.info(key + ":" + jwt.getJWTClaimsSet().getAllClaims().get(key));
				}
				model.addAttribute("user", jwt.getJWTClaimsSet().getStringClaim("unique_name"));
			} catch (ParseException e) {
				log.error("Exception:", e);
			}

		}
		return "/secure/aad";
	}


}
