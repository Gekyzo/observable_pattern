# Build-time vars
ARG JDK_VERSION=17
ARG MVN_DIR=/home/app

# Build stage
FROM maven:3.6.3-openjdk-${JDK_VERSION}-slim AS build
COPY ./src ${MVN_DIR}/src
COPY ./pom.xml ${MVN_DIR}

# Ejecutar Maven
RUN mvn -f ${MVN_DIR}/pom.xml clean package

# Construir JAR
FROM openjdk:${JDK_VERSION}
COPY --from=build ${MVN_DIR}/target/*.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]