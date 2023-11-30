package ru.server.mock.users_json;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import ru.server.mock.myTimer.MyTimer;


@Slf4j
@RestController
@RequestMapping("/api/v2")

// В версии 2 должно быть реализовано всё то что есть в версии 1 но с xml

public class UserControllerV2 {

    private final int timerMin;
    private final int timerMax;


    @Autowired
    public UserControllerV2(@Value("${timerUser.min}") int timerMin, @Value("${timerUser.max}") int timerMax) {
        this.timerMin = timerMin;
        this.timerMax = timerMax;
        log.warn(" timerUserMin = " + timerMin + "  timerUserMax = " + timerMax);
    }

    // XML
    @PostMapping("/users")
    @ResponseBody
    public String printUser(@RequestBody User user,
                            @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                            HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        log.warn(" ");

        return "";
    }



    // GET с id в endpoint
    @GetMapping("/inn/{inn}")
    public String getBodyId(@PathVariable String inn,
                            HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        log.warn("inn - " + inn);
        response.addHeader("inn", inn);
        return String.format("Your INN - %s!", inn);
    }

    // GET с параметром и header
    @GetMapping("/registrynumber")
    public String getBody(@RequestParam(value =  "name", defaultValue = "Ivan") String name,
                          @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                          HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        log.warn("name - " + name + "  trace - " + trace);
        response.addHeader("trace", trace);
        return String.format("Your name - %s! Your registrynumber - %s", name, trace+trace);
    }


}

