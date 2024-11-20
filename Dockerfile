# Use the official OpenJDK 21 base image
FROM --platform=linux/amd64 openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY build/libs/service-0.0.1-SNAPSHOT.jar /app/service-0.0.1-SNAPSHOT.jar

# Expose the port that your Java service listens on
EXPOSE 9820

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "/app/service-0.0.1-SNAPSHOT.jar"]