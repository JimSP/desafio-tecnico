#!/bin/bash

if [ ! -d .git ]; then
    git clone https://github.com/JimSP/desafio-tecnico.git
fi

git pull

./gradlew clean build buildDocker --refresh-dependencies
docker run -p 9000:9000 com.vagas/desafio-tecnico:0.0.1
