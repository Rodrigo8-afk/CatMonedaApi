#imagen modelo para el contenedor que alojara el proyecto de spring
FROM eclipse-temurin:17-jdk-alpine

#Informar en cual puerto funacionara el contenedor de nuestro proyecto
EXPOSE 9001

#Definir el directorio raiz del contenedor
WORKDIR /root

#Copiar y pergar archivos al contenedor
COPY ./pom.xml /root

#Meter maven al contenedor
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

#Descargar las dependencias del proyecto dentro del contenedor
RUN ./mvnw dependency:go-offline

#Compiar el codigo fuente de nuestro proyecto al contenedor
COPY ./src /root/src

#Construir el proyecto o aplicacion
RUN ./mvnw clean install -DskipTests

#Insdicar al contenedor que cada vez que inicie el proyecto se debe de levantar
ENTRYPOINT [ "java","-jar","target/CatMonedaApi-0.0.1-SNAPSHOT.jar" ]