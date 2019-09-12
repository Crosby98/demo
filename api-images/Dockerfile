FROM openjdk:12

ADD ./target/api-images-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/api-images-0.0.1-SNAPSHOT.jar"]

EXPOSE 9003