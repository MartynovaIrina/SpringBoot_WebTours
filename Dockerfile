FROM openjdk:8
EXPOSE 8080
ADD target/webtours.jar webtours.jar
ENTRYPOINT ["java", "-jar", "/webtours.jar"]