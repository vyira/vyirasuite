FROM adoptopenjdk/openjdk11
WORKDIR /home/vyira/
ADD target/quiz-server-0.0.1.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]