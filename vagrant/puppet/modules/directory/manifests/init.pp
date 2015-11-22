class directory {

  file {
    '/tmp/slapd-conf.txt':
      owner => 'root',
      group => 'root',
      mode  => '0600',
      source => 'puppet:///modules/directory/slapd-conf.txt'
     ;
  } ->
  
  file {
    '/tmp/test-directory.ldif':
      owner => 'root',
      group => 'root',
      mode  => '0600',
      source => 'puppet:///modules/directory/test-directory.ldif'
     ;
  } ->
  
  exec {'configure slapd':
    cwd => '/',
    command => '/usr/bin/debconf-set-selections /tmp/slapd-conf.txt',
  } ->

  package { ['slapd']:
    ensure => present;
  } ->

  package { ['ldap-utils']:
   ensure => present;
  } ->

  exec {'import ldif':
    cwd => '/',
    command => "/usr/bin/ldapadd -D 'cn=admin,dc=test,dc=com' -w admin -f /tmp/test-directory.ldif",
  }


# ldapsearch -D 'cn=admin, dc=test, dc=com' -w admin -b "dc=test,dc=com" "objectclass=*"
# ldapsearch -h 192.168.33.10 -D 'cn=admin, dc=test, dc=com' -w admin -b "dc=test,dc=com" "objectclass=*"
# /usr/bin/ldapadd -D 'cn=admin,dc=test,dc=com' -w admin -f /tmp/test-directory.ldif

}
