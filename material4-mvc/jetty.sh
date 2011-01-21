#!/bin/sh

export MAVEN_OPTS="-Xms256m -Xmx512m -XX:MaxPermSize=128m -Xdebug -Xrunjdwp:transport=dt_socket,address=8004,server=y,suspend=n"
#call mvn -e -P jetty-webasset -Djetty.port=80  jetty:run-exploded -P dev-epam

#mvn -e jetty:run-exploded -Djetty.port=8080 -Dmaven.test.skip=true -P dev-epam

mvn -e jetty:run -Djetty.port=8080 -Dmaven.test.skip=true
