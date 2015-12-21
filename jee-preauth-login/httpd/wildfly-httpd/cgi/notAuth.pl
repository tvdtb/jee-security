#!/usr/bin/perl
print "Content-type: text/html\n\n";
print "<html>\n"; 
print "<head>\n"; 
print "<meta http-equiv=\"refresh\" content=\"0; URL=/login/index.jsp?referrer=$ENV{REDIRECT_URL}\">\n";
#print "Caller = $ENV{HTTP_REFERER}\n";
#foreach my $key (sort(keys(%ENV))) {
    #print "$key = $ENV{$key}<br>\n";
#}
print "</head>\n"; 
print "</html>\n"; 
print "\n"; 
