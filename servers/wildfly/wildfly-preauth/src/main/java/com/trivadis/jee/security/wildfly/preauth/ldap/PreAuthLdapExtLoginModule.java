package com.trivadis.jee.security.wildfly.preauth.ldap;

import org.jboss.security.auth.spi.LdapExtLoginModule;

public class PreAuthLdapExtLoginModule extends LdapExtLoginModule {

	@Override
	protected boolean validatePassword(String inputPassword, String expectedPassword) {
		// ignore passwords
		return true;
	}
}
