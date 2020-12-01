FROM openjdk:11.0.9-jdk-slim-buster
MAINTAINER Mohamed Riyas <riyas90cse@gmail.com>

COPY cinematography-service /app/

WORKDIR /app/
RUN ./mvnw clean install -DskipTests=true && ./mvnw spring-boot:run

ENTRYPOINT [ "/bin/bash" ]