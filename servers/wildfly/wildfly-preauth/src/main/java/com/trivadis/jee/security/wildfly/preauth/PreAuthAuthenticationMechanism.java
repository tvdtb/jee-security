package com.trivadis.jee.security.wildfly.preauth;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import io.undertow.security.api.AuthenticationMechanism;
import io.undertow.security.api.SecurityContext;
import io.undertow.security.idm.Account;
import io.undertow.security.idm.PasswordCredential;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.Cookie;

public class PreAuthAuthenticationMechanism implements AuthenticationMechanism {

	private static final char[] EMPTY_CHARS = new char[0];
	private String mechanismName;
	
	private static Logger LOG = Logger.getLogger(PreAuthAuthenticationMechanism.class.getName());

	public PreAuthAuthenticationMechanism(String mechanismName) {
		this.mechanismName = mechanismName;

	}

	@Override
	public AuthenticationMechanismOutcome authenticate(HttpServerExchange exchange, SecurityContext securityContext) {
		AuthenticationMechanismOutcome auth = AuthenticationMechanismOutcome.NOT_AUTHENTICATED;
		Cookie cookie = exchange.getRequestCookies().get("auth");
		if (cookie != null) {
			String accountName = cookie.getValue();
			LOG.info("accountName=" + accountName);

			Account verifiedAccount = securityContext.getIdentityManager().verify(accountName,
					new PasswordCredential(EMPTY_CHARS));
			if (verifiedAccount != null) {
				LOG.info("ACCOUNT: " + verifiedAccount.getPrincipal().getName() //
						+ " roles=" + verifiedAccount.getRoles() //
				);

				securityContext.authenticationComplete(verifiedAccount, mechanismName, true);
				auth = AuthenticationMechanismOutcome.AUTHENTICATED;
			}
		}
		LOG.info("auth result="+auth);
		return auth;
	}

	@Override
	public ChallengeResult sendChallenge(HttpServerExchange req, SecurityContext sc1) {
		return new ChallengeResult(true, HttpServletResponse.SC_UNAUTHORIZED);
	}

}
