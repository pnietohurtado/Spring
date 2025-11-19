# Dockerfile
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copiar el JAR
COPY target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]