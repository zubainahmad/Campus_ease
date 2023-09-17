FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Campus_ease-0.0.1-SNAPSHOT.jar-0.0.1-SNAPSHOT.jar Campus_ease.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Campus_ease.jar"]