FROM kdvolder/jdk8:latest
MAINTAINER Alexandre Moraes <alexandre.msl@gmail.com>
VOLUME /tmp
EXPOSE 22:22 9000:9000
ADD desafio-tecnico-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]