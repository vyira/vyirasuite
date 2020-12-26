FROM adoptopenjdk/openjdk11
ARG APP_FILE=target/recruits*.jar
WORKDIR /home/vyira/
ADD ${APP_FILE} app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","app.jar"]
