# jee-login-basic

A JEE security test project using basic authentication.

Run e.g. with the given [wildfly configuration](../servers/wildfly/wildfly-openldap.md) and the [vagrant](../vagrant/README.md) directory server.

Try the following links

[http://localhost:8080/jee-login-basic/login.info](http://localhost:8080/jee-login-basic/login.info)  (no auth)

[http://localhost:8080/jee-login-basic/secure/login.info](http://localhost:8080/jee-login-basic/secure/login.info)  (basic auth)

[http://localhost:8080/jee-login-basic/secure/admin/login.info](http://localhost:8080/jee-login-basic/secure/admin/login.info) (only admins)


The application displays the known roles.

Runs on
* Wildfly 8.2.1.Final
* Wildfly 9.0.2.Final
* ... and possibly more