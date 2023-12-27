#!/bin/bash
./gradlew build
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/weather-api-ca-jvm .
docker run -i -d --rm -p 8181:8384 quarkus/weather-api-ca-jvm