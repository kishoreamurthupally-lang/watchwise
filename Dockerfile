# Use lightweight Java image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose port (Render uses 8080)
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/*.jar"]
