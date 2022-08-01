FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV RABBITMQ_DEFAULT_USER admin
ENV RABBITMQ_DEFAULT_PASS 123456
EXPOSE 8050
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
