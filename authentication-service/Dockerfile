FROM eclipse-temurin:25-jre

WORKDIR /app

COPY build/libs/*jar authenticationservice.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "authenticationservice.jar"]