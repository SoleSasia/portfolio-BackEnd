FROM amazoncorretto:11-alpine-jdk
MAINTAINER emaaristimuno
COPY target/portfolio-0.2.0.jar portfolio-0.2.0.jar
ENTRYPOINT ["sh", "-c", "java","-jar","/app-portfolio.jar"]
