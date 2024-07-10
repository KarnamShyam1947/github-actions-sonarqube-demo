# Stage 1: Build the Spring Boot application
FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

# Stage 2: Create the final image
FROM openjdk:17-alpine
WORKDIR /app
# Copy the JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
