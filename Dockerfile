FROM eclipse-temurin:21-jdk-jammy

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Default command
CMD ["mvn", "test"]