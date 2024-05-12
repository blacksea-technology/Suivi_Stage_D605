# Étape de construction Maven
FROM maven:3.8.4-openjdk-17-slim AS builder

# Copier le code source de votre application dans le conteneur
COPY . /app

# Définir le répertoire de travail
WORKDIR /app

# Exécuter la construction Maven
#RUN mvn clean install && \
#    rm -rf /root/.m2
RUN mvn clean package -DskipTests
# Étape de construction de l'image finale
FROM eclipse-temurin:17.0.10_7-jdk AS final

# Copier les artefacts construits à partir de l'étape précédente dans le conteneur final
COPY --from=builder /app/target/*.jar /app/suivistage.jar

# Commande pour exécuter l'application lorsque le conteneur démarre
CMD ["java", "-jar", "/app/suivistage.jar"]
