#!/bin/bash
mvn clean install
cp target/movies1.war  ~/Maven_Home/wildfly-10.1.0.Final/standalone/deployments
