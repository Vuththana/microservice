FROM eclipse-temurin:25-jre

WORKDIR /app

COPY build/libs/*.jar userservice.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "userservice.jar"]