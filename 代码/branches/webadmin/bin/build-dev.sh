#!/bin/bash
mvn clean package -Pdev -Dmaven.test.skip=true

read -n1 -p "Press any key to continue..."
