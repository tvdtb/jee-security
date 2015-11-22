

This is the security-domain configuration for Wildfly and the included OpenLdap scenario:

	<subsystem xmlns="urn:jboss:domain:security:.....">
	<security-domains>
	...
	<security-domain name="ldap" cache-type="default">
		<authentication>
			<login-module code="LdapExtended" flag="required">
				<module-option name="java.naming.provider.url" value="ldap://192.168.33.10:389/"/>
				<module-option name="bindDN" value="cn=admin, dc=test, dc=com"/>
				<module-option name="bindCredential" value="admin"/>
				<module-option name="baseCtxDN" value="ou=people,dc=test, dc=com"/>
				<module-option name="baseFilter" value="(&amp;(objectclass=person)(uid={0}))"/>
				<module-option name="rolesCtxDN" value="ou=groups,dc=test,dc=com"/>
				<module-option name="roleFilter" value="(&amp;(objectclass=groupOfNames)(member={1}))"/>
				<module-option name="roleAttributeID" value="cn"/>
				<module-option name="defaultRole" value="AllAuthenticatedUsers"/>
			</login-module>
		</authentication>
	</security-domain>
	...
	</security-domains>
	</subsystem>
	
	
For logging (to server.log) insert the following lines to the logging subsystem:

	<logger category="org.jboss.security">
		<level name="TRACE"/>
	</logger>
