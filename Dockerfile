FROM openjdk:16
VOLUME /tmp
COPY target/*.jar avizandum-world.jar
ENTRYPOINT ["java", "-jar", "/avizandum-world.jar"]