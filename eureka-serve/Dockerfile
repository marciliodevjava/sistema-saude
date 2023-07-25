FROM openjdk:20

WORKDIR /app

COPY target/eureka-serve-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]