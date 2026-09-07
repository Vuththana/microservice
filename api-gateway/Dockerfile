FROM eclipse-temurin:25-jre

WORKDIR /app

COPY build/libs/*.jar apigateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "apigateway.jar"]