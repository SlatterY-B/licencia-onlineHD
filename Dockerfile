# Imagen base oficial de Maven con JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copiamos todo el contenido del proyecto
COPY . .

# Compilamos el proyecto (sin tests para que no falle)
RUN mvn clean package -DskipTests

# Imagen final liviana (solo el JAR)
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Puerto (por si lo usas en local)
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
