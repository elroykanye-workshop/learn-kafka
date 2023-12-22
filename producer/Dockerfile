FROM openjdk:17-jdk-alpine
MAINTAINER elroykanye
WORKDIR /app
COPY ./build/libs/producer-0.0.1-SNAPSHOT.jar app-producer.jar
USER nobody
ENTRYPOINT ["java","-jar","/app/app-producer.jar"]
