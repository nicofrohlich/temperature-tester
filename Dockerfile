FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package
RUN ls -l /app/target  # Verifique se o JAR foi gerado

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/temperature-tester-0.0.1-SNAPSHOT.jar app.jar
RUN ls -l /app         # Verifique se o JAR foi copiado corretamente
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
