FROM openjdk:17-oracle
COPY ./target/Authentication-Service-0.0.1-SNAPSHOT.jar authentication-service.jar
CMD ["java","-jar","authentication-service.jar"]