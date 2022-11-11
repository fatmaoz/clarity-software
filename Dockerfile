FROM openjdk:11-jdk
COPY ./target/clarity-sotware-0.0.1-SNAPSHOT.jar  /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","clarity-sotware-0.0.1-SNAPSHOT.jar"]