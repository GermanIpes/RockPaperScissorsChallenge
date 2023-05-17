FROM openjdk:12-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /RockPaperScissorsChallenge

CMD chmod +x ./gradlew run