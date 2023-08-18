FROM openjdk:17
WORKDIR /rosa
COPY target/rosa.jar /rosa
EXPOSE 8080
CMD ["java", "-jar", "rosa.jar"]


#
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} rosa.jar
#ENTRYPOINT ["java","-jar","/rosa.jar"]