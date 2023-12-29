# Step 1: Use the official OpenJDK 17 image as the base image
FROM openjdk:17

# Step 2: Set a working directory inside the container
WORKDIR /

# Step 3: Copy the jar file from your host to the container
COPY target/prometheus-feeder-0.0.1-SNAPSHOT.jar /prometheus-feeder-0.0.1-SNAPSHOT.jar

# Step 4: Expose the port your app runs on
EXPOSE 8080

# Step 5: Define the command to run your app
CMD ["java", "-jar", "/prometheus-feeder-0.0.1-SNAPSHOT.jar"]