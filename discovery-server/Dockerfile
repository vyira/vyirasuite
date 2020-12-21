FROM adoptopenjdk/openjdk11
WORKDIR /home/vyira/
ADD target/discovery-server-0.0.1.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","app.jar"]