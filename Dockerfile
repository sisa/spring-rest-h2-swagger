FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD target/demo-rest-1.0.0.jar app.jar

ENTRYPOINT exec java -jar app.jar