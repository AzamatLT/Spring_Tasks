package mock.spring.multithreading.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import mock.spring.multithreading.myTimer.MyTimer;
import mock.spring.multithreading.service.ServiceMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.atomic.AtomicLong;




@Slf4j
@RestController
public class GetController {
    private final int timerMin;
    private final int timerMax;


    @Autowired
    public GetController(@Value("${timer.min}") int timerMin, @Value("${timer.max}") int timerMax) {
        this.timerMin = timerMin;
        this.timerMax = timerMax;
        log.warn(" timerMin = " + timerMin + "  timerMax = " + timerMax);
    }



    //Считает количество запросов
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/getname")
    public String getname(@RequestParam(value = "name", defaultValue = "Oleg") String name,
                             @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                             HttpServletResponse response) {

        MyTimer.myTimer(timerMin, timerMax);

        log.warn("getname - " + name + ", " + "   trace - " + trace);
        response.addHeader("trace", trace);
        ServiceMock mockName = new ServiceMock();
        return "{\n" +
                "\t\"increment\": \"" + counter.incrementAndGet()+"\",\n" +
                "\t\"name\": \"" + mockName.saveUsers(name) +"\",\n" +
                "}";
    }


}