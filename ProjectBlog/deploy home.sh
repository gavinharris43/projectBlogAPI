#!/bin/bash
mvn clean install
cp target/movies1.war  C:/Users/Gavin/wildfly-10.1.0.Final/standalone/deployments
