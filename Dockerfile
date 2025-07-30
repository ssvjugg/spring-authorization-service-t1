FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
COPY .env .env

RUN chmod +x mvnw && \
    ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/spring-authorization-service-t1-0.0.1-SNAPSHOT.jar"]