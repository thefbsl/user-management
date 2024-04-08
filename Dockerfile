FROM amazoncorretto:17

WORKDIR /app

COPY target/springboot-restful-webservices-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]