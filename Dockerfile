# Docker Build Stage
FROM maven:3-jdk-8-alpine AS build


# Build Stage
WORKDIR /home/ubuntudesktop/app

COPY ./ /home/ubuntudesktop/app
RUN mvn clean install -DskipTests


# Docker Build Stage
FROM openjdk:8-jdk-alpine

COPY --from=build /home/ubuntudesktop/app/target/*.jar app.jar

ENV PORT 8099
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]
