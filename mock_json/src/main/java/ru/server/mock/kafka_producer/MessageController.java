package ru.server.mock.kafka_producer;

//import com.knf.dev.demo.producer.service.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    Producer producer;

    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/kafka")
    public String publishMessage(@RequestParam(value = "name", defaultValue = "World") String kafka_name) {

        producer.sendMessageToTopic(kafka_name);

        log.info(String.valueOf(kafka_name));
        return "Message was sent successfully";
    }
}
