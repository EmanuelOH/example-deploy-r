FROM maven:3-eclipse-temurin-17 AS build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /target/example-SS-JWT-0.1.jar example.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "example.jar"]