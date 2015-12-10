package com.trivadis.jee.security.wildfly.preauth;

import io.undertow.security.api.AuthenticationMechanism;
import io.undertow.security.api.AuthenticationMechanismFactory;
import io.undertow.server.handlers.form.FormParserFactory;

import java.util.Map;

public class PreAuthFactory implements AuthenticationMechanismFactory {
	@Override
	public AuthenticationMechanism create(String mechanismName,
			FormParserFactory formParserFactory, Map<String, String> properties) {
		return new PreAuthAuthenticationMechanism(mechanismName);
	}
}