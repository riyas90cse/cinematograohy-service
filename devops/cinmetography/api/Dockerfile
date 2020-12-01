FROM app-base
MAINTAINER Mohamed Riyas <riyas90cse@gmail.com>

RUN mkdir -p /opt/cinematography/api && mkdir -p /etc/cinematography/files

WORKDIR /app/api/

EXPOSE 9000

ENTRYPOINT ../mvnw clean install -DskipTests=true