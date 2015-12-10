package com.trivadis.jee.security.wildfly.preauth;

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

	public PreAuthAuthenticationMechanism(String mechanismName) {
		this.mechanismName = mechanismName;

	}

	@Override
	public AuthenticationMechanismOutcome authenticate(HttpServerExchange exchange, SecurityContext securityContext) {
		System.out.println("AUTHENTICATE ");

		AuthenticationMechanismOutcome auth = AuthenticationMechanismOutcome.NOT_AUTHENTICATED;
		Cookie cookie = exchange.getRequestCookies().get("auth");
		if (cookie != null) {
			String accountName = cookie.getValue();
			System.out.println("   accountName=" + accountName);

			Account verifiedAccount = securityContext.getIdentityManager().verify(accountName,
					new PasswordCredential(EMPTY_CHARS));
			if (verifiedAccount != null) {
				System.out.println("ACCOUNT: " + verifiedAccount.getPrincipal().getName() //
						+ " roles=" + verifiedAccount.getRoles() //
						+ "  account=" + verifiedAccount //
				);

				securityContext.authenticationComplete(verifiedAccount, mechanismName, true);
				auth = AuthenticationMechanismOutcome.AUTHENTICATED;
			}
		}
		return auth;
	}

	@Override
	public ChallengeResult sendChallenge(HttpServerExchange arg0, SecurityContext arg1) {
		return new ChallengeResult(true, HttpServletResponse.SC_UNAUTHORIZED);
	}

}
