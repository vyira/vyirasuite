FROM adoptopenjdk/openjdk11
ARG APP_FILE=target/discovery-server*.jar
WORKDIR /home/vyira/
ADD ${APP_FILE} app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","app.jar"]
