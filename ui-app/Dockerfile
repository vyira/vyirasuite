FROM adoptopenjdk/openjdk11
ARG APP_FILE=target/ui-app*.war
WORKDIR /home/vyira/
ADD ${APP_FILE} app.war
EXPOSE 80
EXPOSE 443
ENTRYPOINT ["java","-jar","app.war"]
