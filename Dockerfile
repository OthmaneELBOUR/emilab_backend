# Utilise une image Java 17
FROM eclipse-temurin:17-jdk-jammy

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier JAR généré dans le conteneur
COPY target/*.jar app.jar

# Expose le port de l'application (généralement 8080 pour Spring Boot)
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]