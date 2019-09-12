FROM openjdk:12

ADD ./target/srv-discovery-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/srv-discovery-0.0.1-SNAPSHOT.jar"]

EXPOSE 8761