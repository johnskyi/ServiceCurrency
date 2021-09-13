FROM  adoptopenjdk/openjdk15:alpine
VOLUME /usr/app
EXPOSE 8080
ARG JAR_FILE=build/libs/ServiceCurrency-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ServiceCurrency-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ServiceCurrency-0.0.1-SNAPSHOT.jar","-Dspring.config.location=/config/"]