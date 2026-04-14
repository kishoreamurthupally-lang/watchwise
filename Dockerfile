FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# ✅ FIX: Give permission to mvnw
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
