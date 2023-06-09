FROM maven:3.8.6-jdk-8-slim AS build

RUN mkdir -p /workspace

WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src

RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine

COPY --from=build /workspace/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080
