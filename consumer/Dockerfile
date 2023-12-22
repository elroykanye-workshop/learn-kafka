FROM openjdk:17-jdk-alpine
MAINTAINER elroykanye
WORKDIR /app
COPY ./build/libs/consumer-0.0.1-SNAPSHOT.jar app-consumer.jar
USER nobody
ENTRYPOINT ["java","-jar","/app/app-consumer.jar"]
