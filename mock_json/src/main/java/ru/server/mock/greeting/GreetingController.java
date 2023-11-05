package ru.server.mock.greeting;

import java.util.concurrent.atomic.AtomicLong;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.server.mock.myTimer.MyTimer;


@Slf4j
@RestController
public class GreetingController {
    private final int timerMin;
    private final int timerMax;


    @Autowired
    public GreetingController(@Value("${timerGreeting.min}") int timerMin, @Value("${timerGreeting.max}") int timerMax) {
        this.timerMin = timerMin;
        this.timerMax = timerMax;
        log.warn(" timerGreetingMin = " + timerMin + "  timerGreetingMax = " + timerMax);
    }

   // Logger logger = LoggerFactory.getLogger(GreetingController.class);
   // private static final String templateName = "%s";
   // private static final String templateGreeting = "Your greeting - %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Oleg") String name,
                             @RequestParam(value = "greeting", defaultValue = "Hello") String greeting,
                             @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                             HttpServletResponse response) {

        MyTimer.myTimer(timerMin, timerMax);

        log.warn("greeting - " + name + ", " + greeting + "   trace - " + trace);
        response.addHeader("trace", trace);
       // return new Greeting(counter.incrementAndGet(), String.format(templateName, name), String.format(templateGreeting, greeting));
        return new Greeting(counter.incrementAndGet(), name, greeting);
    }


}