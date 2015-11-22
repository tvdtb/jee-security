# jee-login-basic

A JEE security test project using basic authentication.

Run e.g. with the given [wildfly configuration](../servers/wildfly/wildfly-openldap.md) and the [vagrant](../vagrant/README.md) directory server.

Try the following links

[http://localhost:8080/jee-security-basic/]  (no auth)

[http://localhost:8080/jee-security-basic/secure/]   (basic auth)

[http://localhost:8080/jee-security-basic/secure/admin/] (only admins)


The application displays the known roles.

Runs on
* Wildfly 8.2.1.Final
* Wildfly 9.0.2.Final
* ... and possibly more