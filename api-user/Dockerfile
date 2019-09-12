FROM openjdk:12

ADD ./target/api-user-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/api-user-0.0.1-SNAPSHOT.jar"]

EXPOSE 9010