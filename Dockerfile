# Use OpenJDK 21 as the base image for building the application
FROM openjdk:21-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew build.gradle settings.gradle ./
COPY gradle gradle/

# Copy the source code into the container
COPY src src/

# Build the application
RUN ./gradlew build --no-daemon

# Use a minimal base image for the runtime
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/happy-service.jar app.jar

# Expose port 1000
EXPOSE 1000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
