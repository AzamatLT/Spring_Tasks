package ru.server.mock;

import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        /*    logger.trace("A TRACE Message");
            logger.debug("A DEBUG Message");
            logger.info("An INFO Message");
            logger.warn("A WARN Message");
            logger.error("An ERROR Message");

         */

        log.info(String.valueOf(name));
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }


}