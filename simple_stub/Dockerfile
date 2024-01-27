FROM bellsoft/liberica-openjdk-alpine-musl
LABEL type=Stab
EXPOSE 8080:8080
COPY ./target/stub-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","stub-0.0.1-SNAPSHOT.jar"]