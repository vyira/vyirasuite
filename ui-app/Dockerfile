FROM adoptopenjdk/openjdk11
WORKDIR /home/vyira/
ADD target/ui-app-0.0.1.war app.war
EXPOSE 80
EXPOSE 443
ENTRYPOINT ["java","-jar","app.jar"]