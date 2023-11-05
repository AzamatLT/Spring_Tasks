package ru.server.mock.users_json;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import ru.server.mock.myTimer.MyTimer;


@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserControllerV1 {

    private final int timerMin;
    private final int timerMax;


    @Autowired
    public UserControllerV1(@Value("${timerUser.min}") int timerMin, @Value("${timerUser.max}") int timerMax) {
        this.timerMin = timerMin;
        this.timerMax = timerMax;
        log.warn(" timerUserMin = " + timerMin + "  timerUserMax = " + timerMax);
    }

    @PostMapping("/users")
    @ResponseBody
    public String publishtUser(@RequestBody User user,
                               @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                               HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        log.warn("Print User Object " + user);
// Парсим JSON
        response.addHeader("trace", trace);
        response.addHeader("Your name", user.toParseName(user));
        response.addHeader("Your location", user.toParseLocation(user));
        response.addHeader("Your age", String.valueOf(user.toParseAge(user)));
        response.addHeader("Your message", user.toString()); //Передаём header сформированный в User.toString() из request
// Отправляем самостоятельно собранный JSON
        return "{\n" +
                "\t\"name\": \"" + user.toParseName(user)+"\",\n" +
                "\t\"city\": \"" + user.toParseLocation(user)+"\",\n" +
                "\t\"age\": " + String.valueOf(user.toParseAge(user))+" \n" +
                "}";
    }



    // GET с id в endpoint
    @GetMapping("/inn/{inn}")
    public String getBodyId(@PathVariable String inn,
                            HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        response.addHeader("inn", inn);
        return String.format("Your INN - %s!", inn);
    }

    // GET с параметром и header
    @GetMapping("/registrynumber")
    public String getBody(@RequestParam(value =  "name", defaultValue = "Ivan") String name,
                          @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                          HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        response.addHeader("trace", trace);
        return String.format("Your name - %s! Your registrynumber - %s", name, trace+trace);
    }


}

