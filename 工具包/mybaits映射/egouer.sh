#!/bin/bash
mkdir output
java -jar lib/mybatis-generator-core-1.3.2.jar -configfile egouer.xml $1 -overwrite
read -n1 -p "Press any key to continue..."
