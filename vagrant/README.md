# vagrant

A [http://vagrantup.com] server configuration.

Refer to [puppet/manifests/site.pp] for the current set of active configurations.

## Environment
*Box Image: ubuntu/trusty64
*Networking: Private, 192.168.33.10

## Basic configuration (active)
Performs some basic configuration steps

## Webserver (disabled)
Configures appache httpd

## Directory (active)
Configures the server for OpenLDAP and the follwing configuration:

* BaseDN: dc=test,dc=com
* Admin: cn=admin,dc=test,dc=com
* Password: admin

Users (as defined in [modules/directory/files/test-directory.de]):

* User: test1  Password: test  Roles: users, admins
* User: test2  Password: test  Roles: users, developers
* User: test3  Password: test  Roles: n/a

