FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /build

COPY src /build/src

COPY pom.xml /build/

RUN mvn clean install

FROM openjdk:8-jdk-alpine

COPY --from=build /build/target/api-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]