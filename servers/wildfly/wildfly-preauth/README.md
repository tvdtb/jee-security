# Wildfly Pre-Authenticated LDAP User

This module enables JEE default authentication using pre-Authenticated Users (login delegated to another application).
It requires a Cookie to be sent with each request which authenticates the user.

To achieve that, the password needs to be ignored, this is the openLDAP configuration for that:

This is the security-domain configuration for Wildfly and the included OpenLdap scenario:

	<subsystem xmlns="urn:jboss:domain:security:.....">
	<security-domains>
	...
	<security-domain name="ldapPreAuth" cache-type="default">
		<authentication>
			<login-module code="com.trivadis.jee.security.wildfly.preauth.ldap.PreAuthLdapExtLoginModule" flag="required">
				<module-option name="java.naming.provider.url" value="ldap://192.168.33.10:389/"/>
				<module-option name="bindDN" value="cn=admin, dc=test, dc=com"/>
				<module-option name="bindCredential" value="admin"/>
				<module-option name="baseCtxDN" value="ou=people,dc=test, dc=com"/>
				<module-option name="baseFilter" value="(&amp;(objectclass=person)(uid={0}))"/>
				<module-option name="rolesCtxDN" value="ou=groups,dc=test,dc=com"/>
				<module-option name="roleFilter" value="(&amp;(objectclass=groupOfNames)(member={1}))"/>
				<module-option name="roleAttributeID" value="cn"/>
				<module-option name="defaultRole" value="AllAuthenticatedUsers"/>
				<module-option name="allowEmptyPasswords" value="true"/>
			</login-module>
		</authentication>
	</security-domain>
	...
	</security-domains>
	</subsystem>
	
	
