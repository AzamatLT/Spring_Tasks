FROM bellsoft/liberica-openjdk-alpine-musl
LABEL type=Stab_Kafka
EXPOSE 8080:8080
COPY ./target/stub_kafka-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","stub_kafka-0.0.1-SNAPSHOT.jar"]