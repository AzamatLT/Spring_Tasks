package ru.server.mock.kafka_producer;


public class KafkaId {

    private String name;

    private String id;

    private String inn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", INN=" + id +
                '}';
    }

    public String toParseName(KafkaId kafkaId) {
        String name = this.name;
        return name;
    }
    public String toParseId(KafkaId kafkaId) {
        String id = this.id;
        return id;
    }
    public String toParseINN(KafkaId kafkaId) {
        String inn = this.inn;
        return inn;
    }
}


