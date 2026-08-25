FROM amazoncorretto:11-alpine-jdk
LABEL maintainer=emaaristimuno
COPY target/portfolio-0.2.0.jar portfolio.jar
ENTRYPOINT ["sh", "-c", "java -jar portfolio.jar"]
