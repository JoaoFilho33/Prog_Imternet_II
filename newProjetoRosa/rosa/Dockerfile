FROM openjdk:17-alpine
ENV APP_NAME rosa
COPY ./target/${APP_NAME}.jar  /app/${APP_NAME}.jar
WORKDIR /app
CMD java -jar ${APP_NAME}.jar
EXPOSE 8080


#
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} rosa.jar
#ENTRYPOINT ["java","-jar","/rosa.jar"]