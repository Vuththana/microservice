FROM eclipse-temurin:25-jre

WORKDIR /app

COPY build/libs/*.jar eurekaserver.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eurekaserver.jar"]