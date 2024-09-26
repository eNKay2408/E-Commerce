FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY .env .

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

RUN addgroup app && adduser -S -G app app
RUN chown -R app:app /app

USER app

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]