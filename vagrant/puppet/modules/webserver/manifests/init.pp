class webserver {
  package { ['apache2']:
    ensure => present;
  } ->

  exec { 'a2enmod rewrite proxy ':
    command => '/usr/bin/sudo /usr/sbin/a2enmod rewrite proxy proxy_http',
    notify  => Service["apache2"] # Restart ssh server if being updated
    ;
  } ->

  file {
    '/etc/apache2/conf-enabled/test-proxy.conf':
      owner => 'root',
      group => 'root',
      mode  => '0600',
      source => 'puppet:///modules/webserver/proxy-test.conf',
      notify  => Service["apache2"] # Restart ssh server if being updated
     ;
  }


  # Ensure the ssh server is running
  service { "apache2":
    ensure  => "running",
    enable  => "true",
  }


}
