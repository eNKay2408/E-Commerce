FROM maven:3.8-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY .env .

ARG JAR_FILE=/app/target/*.jar

COPY --from=build ${JAR_FILE} app.jar

RUN addgroup app && adduser -S -G app app

RUN chown app:app ./app.jar

USER app

EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]