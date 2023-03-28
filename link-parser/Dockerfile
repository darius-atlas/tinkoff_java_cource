# Base image
FROM openjdk:11

# Working directory
WORKDIR /app

# Copying the JAR file
COPY target/link-parser-1.0-SNAPSHOT.jar /app/link-parser.jar

# Command to run the JAR file
CMD ["java", "-jar", "target/link-parser-1.0-SNAPSHOT.jar"]