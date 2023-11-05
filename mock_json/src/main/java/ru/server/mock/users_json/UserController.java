package ru.server.mock.users_json;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;



@RestController
@ConfigurationProperties(prefix = "timer")
public class UserController {

    private final int timer;


    @Autowired
    public UserController(@Value("${timer}") int timer) {
        this.timer = timer;
        System.out.println(" timer = " + timer);
    }

    @PostMapping("/users")
    @ResponseBody
    public String printUser(@RequestBody User user,
                            @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                            HttpServletResponse response) {
        myTimer(timer);
        System.out.println("Print User Object " + user);

        response.addHeader("trace", trace);
        response.addHeader("Your name", user.toParseName(user));
        response.addHeader("Your location", user.toParseLocation(user));
        response.addHeader("Your age", String.valueOf(user.toParseAge(user)));
        response.addHeader("Your message", user.toString()); //Передаём header сформированный в User.toString() из request
        return "{\n" +
                "\t\"name\": \""+user.toParseName(user)+"\",\n" +
                "\t\"city\": \""+user.toParseLocation(user)+"\",\n" +
                "\t\"age\": "+String.valueOf(user.toParseAge(user))+" \n" +
                "}"; //Передаём ответ/body сформированное тут же  из request
    }



    // GET с id в endpoint
    @GetMapping("/inn/{inn}")
    public String getBodyId(@PathVariable String inn,
                            HttpServletResponse response) {
        myTimer(timer);
        response.addHeader("inn", inn);
        return String.format("Your INN - %s!", inn);
    }

    // GET с параметром и header
    @GetMapping("/registrynumber")
    public String getBody(@RequestParam(value =  "name", defaultValue = "Ivan") String name,
                          @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                          HttpServletResponse response) {
        myTimer(timer);
        response.addHeader("trace", trace);
        return String.format("Your name - %s! Your registrynumber - %s", name, trace+trace);
    }


    // Самый простой ответ да на корень. любой метод.

    @RequestMapping("/**")
    public String getAny() {
        myTimer(timer);

        return ("");
    }


    private void myTimer(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

