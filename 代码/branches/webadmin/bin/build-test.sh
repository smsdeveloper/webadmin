#!/bin/bash
mvn clean package -Ptest -Dmaven.test.skip=true

read -n1 -p "Press any key to continue..."
