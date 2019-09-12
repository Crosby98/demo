FROM openjdk:12

ADD ./target/srv-config-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/srv-config-0.0.1-SNAPSHOT.jar"]

EXPOSE 9001