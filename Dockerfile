FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy Maven wrapper and config
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

# Copy source
COPY src ./src

# Build
RUN ./mvnw package -DskipTests

EXPOSE 8080

# Find the built jar automatically
CMD ["sh", "-c", "java -jar target/*.jar"]
