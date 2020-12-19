FROM adoptopenjdk/openjdk11
WORKDIR /home/vyira/
ADD target/recruits-0.0.1.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","app.jar"]