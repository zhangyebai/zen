#!/bin/bash

echo 'start build project with gradle'
name=$(basename $0)
echo $name
gradle build -x test
cp ./build/libs/zen-0.0.1-SNAPSHOT.jar zen.jar
docker stop zen
docker rm zen
docker build -t springboot_jdk18 --no-cache .
docker run -p 0.0.0.0:8080:8090 --network zen --name zen -d springboot_jdk18


