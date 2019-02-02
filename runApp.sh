#!/bin/bash

if [ ! -d .git ]; then
    git clone https://github.com/JimSP/desafio-tecnico.git
fi

git pull
./gradlew clean build buildDocker --refresh-dependencies
docker run
