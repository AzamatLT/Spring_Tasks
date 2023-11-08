package ru.server.mock.kafka_producer;

//import com.knf.dev.demo.producer.service.Producer;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.server.mock.myTimer.MyTimer;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final int timerMin;
    private final int timerMax;

    Producer producer;
    @Autowired
    public MessageController(@Value("${timerKafka.min}") int timerMin, @Value("${timerKafka.max}") int timerMax, Producer producer) {
        this.timerMin = timerMin;
        this.timerMax = timerMax;
        this.producer = producer;
        log.warn(" timerKafkaMin = " + timerMin + "  timerKafkaMax = " + timerMax);
    }


    @GetMapping("/kafka")
    public String publishMessage(@RequestParam(value = "name", defaultValue = "World") String kafka_name) {

        MyTimer.myTimer(timerMin, timerMax);
        log.warn("kafka_Message - " + kafka_name);

        producer.sendMessageToTopic(kafka_name);


        return "Message was sent successfully";
    }

    // При получении POST отправляем весь полученный JSON в сообщение кафки, ???а headerTrace в key кафки
    @PostMapping("/kafka")
    @ResponseBody
    public String publishMessagePost(@RequestBody String kafka_Message,
                                     @RequestHeader(value =  "headerTrace", defaultValue = "111111") String headerTrace,
                                     HttpServletResponse response)  {


        MyTimer.myTimer(timerMin, timerMax);
        log.warn("kafka_Message - " + kafka_Message);

        producer.sendMessageToTopic(kafka_Message);


        return "Message was sent successfully";
    }

    // При получении POST отправляем полученный ID из JSON в сообщение кафки, ???а headerTrace в key кафки
    @PostMapping("/kafkaid")
    @ResponseBody
    public String publishMessagePostId(@RequestBody KafkaId kafkaId,
                                     @RequestHeader(value =  "headerTrace", defaultValue = "111111") String headerTrace,
                                     HttpServletResponse response)  {


        MyTimer.myTimer(timerMin, timerMax);
        log.warn("kafka_Message_Id - " + kafkaId.toParseId(kafkaId));

        producer.sendMessageToTopic(kafkaId.toParseId(kafkaId));


        return "ID was sent successfully";
    }
}
