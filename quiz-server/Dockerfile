FROM adoptopenjdk/openjdk11
ARG APP_FILE=target/quiz-server*.jar
WORKDIR /home/vyira/
ADD ${APP_FILE} app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]
