FROM maven:3.8.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/temperature-tester-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
