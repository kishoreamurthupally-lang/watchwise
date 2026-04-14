# -------- BUILD STAGE --------
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

# ✅ FIX HERE
RUN mvn clean package -Dmaven.test.skip=true

# -------- RUNTIME STAGE --------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
