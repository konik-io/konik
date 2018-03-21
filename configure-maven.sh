#!/bin/bash

sed -i~ "/<servers>/ a\
<server>\
  <id>private-repo</id>\
  <username>${nexusUsername}</username>\
  <password>${nexusPassword}</password>\
</server>" /usr/share/maven/conf/settings.xml

sed -i "/<mirrors>/ a\
<mirror>\
  <id>private-repo</id>\
  <name>central</name>\
  <url>https://repo.objective-partner.de/repository/maven-public/</url>\
  <mirrorOf>*</mirrorOf>\
</mirror>" /usr/share/maven/conf/settings.xml

sed -i "/<profiles>/ a\
<profile>\
  <id>private-repo</id>\
  <activation>\
    <activeByDefault>true</activeByDefault>\
  </activation>\
  <repositories>\
    <repository>\
      <id>private-repo</id>\
      <url>https://repo.objective-partner.de/repository/maven-public/</url>\
    </repository>\
  </repositories>\
  <pluginRepositories>\
    <pluginRepository>\
      <id>private-repo</id>\
      <url>https://repo.objective-partner.de/repository/maven-public/</url>\
    </pluginRepository>\
  </pluginRepositories>\
</profile>\
<profile>\
  <id>sonar</id>\
  <activation>\
    <activeByDefault>true</activeByDefault>\
  </activation>\
  <properties>\
    <sonar.host.url>${SONAR_HOST_URL}</sonar.host.url>\
    <sonar.login>${SONAR_LOGIN}</sonar.login>\
    <sonar.branch>${BITBUCKET_BRANCH}</sonar.branch>\
  </properties>\
</profile>" /usr/share/maven/conf/settings.xml