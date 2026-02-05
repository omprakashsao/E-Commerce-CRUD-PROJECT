# ===============================
# Stage 1: Build Application
# ===============================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Build jar (skip tests for faster build)
RUN mvn clean package -DskipTests

# ===============================
# Stage 2: Runtime (Distroless)
# ===============================
FROM gcr.io/distroless/java21-debian12

# Set working directory
WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8081

# Run application
ENTRYPOINT ["java","-Xms128m","-Xmx384m","-jar","app.jar"]


