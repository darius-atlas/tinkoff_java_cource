# Base image
FROM openjdk:11

# Working directory
WORKDIR /app

# Copying the JAR file
COPY target/scrapper-1.0-SNAPSHOT.jar /app/scrapper.jar

# Exposing the port on which the application will run
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "target/scrapper-1.0-SNAPSHOT.jar"]