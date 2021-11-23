FROM openjdk:11
COPY build/libs/concept-0.1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]