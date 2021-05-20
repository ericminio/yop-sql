#!/bin/bash

/usr/local/src/oracle/wait.sh

mvn clean package

cd target
java \
    -Dyop.config=/usr/local/src/working/config.json \
    -Dyop.input=/usr/local/src/working/input.sql \
    -Dyop.output=/usr/local/src/working/yop.output \
    -Djava.util.logging.SimpleFormatter.format="[%4\$s] %2\$s - %5\$s %n" \
    -cp ~/.m2/repository/com/oracle/database/jdbc/ojdbc8/21.1.0.0/ojdbc8-21.1.0.0.jar:yop-sql-1.0.jar \
    yopsql.main.Cli
