FROM openjdk:11 AS int-build
LABEL description="Java Application builder"
RUN git clone https://github.com/yoonicode94/poppin_back
WORKDIR poppin_back
ARG CACHE_BUST=1
RUN chmod 700 mvnw
RUN ./mvnw clean package

FROM openjdk:11-jre-slim
LABEL description="Spring Boot Application"
EXPOSE 60433
COPY --from=int-build poppin/target/app-in-host.jar /opt/app-in-image.jar
WORKDIR /opt
ENTRYPOINT [ "java", "-jar", "app-in-image.jar" ]
