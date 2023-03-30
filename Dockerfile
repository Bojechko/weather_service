FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/nanay-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Weather.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=8083", "Weather.jar"]
