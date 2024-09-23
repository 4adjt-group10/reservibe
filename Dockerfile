# Use uma imagem base do Maven para construir a aplicação
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use uma imagem base do OpenJDK para executar a aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/Reservibe.jar /app/Reservibe.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Reservibe.jar"]