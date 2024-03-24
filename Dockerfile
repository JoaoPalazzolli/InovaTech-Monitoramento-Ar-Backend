FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

RUN mkdir "/home/monitoramento-ar"
COPY . /home/monitoramento-ar

RUN cd /home/monitoramento-ar && mvn clean install

FROM tomcat:10.1.19-jdk17

LABEL maintainer="tomcat"

COPY --from=build /home/monitoramento-ar/target/monitoramento-ar-1.0-SNAPSHOT.war /usr/local/tomcat/webapps

EXPOSE 8080

CMD ["catalina.sh", "run"]