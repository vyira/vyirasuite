FROM openjdk:11 AS builder
WORKDIR source
ARG APP_FILE=target/quiz-server*.jar
ADD ${APP_FILE} app.jar
EXPOSE 8090
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:11-jre-slim
WORKDIR /home/vyira/
COPY --from=builder source/dependencies/ ./
COPY --from=builder source/spring-boot-loader/ ./
COPY --from=builder source/snapshot-dependencies/ ./
COPY --from=builder source/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]
