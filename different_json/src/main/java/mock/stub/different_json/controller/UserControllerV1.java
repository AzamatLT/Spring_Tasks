package mock.stub.different_json.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserControllerV1 {

    @Value("${TIMER_MIN:100}")
    private String timerMin;

    @Value("${TIMER_MAX:200}")
    private String timerMax;

    private long time;
    private String responseJSON;

//  Получаем JSON, отправляем рандомный JSON

    @PostMapping("/inn")
    @ResponseBody
    public String publishtUser(@RequestBody User user,
                               @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                               HttpServletResponse response) throws InterruptedException {

        time = (long) (Math.random() * (Integer.parseInt(timerMax) - Integer.parseInt(timerMin)) + Integer.parseInt(timerMin));
        System.out.println("Random Timer - " + time);
        Thread.sleep(time);

        System.out.println("Print User Object " + user);
// Парсим JSON
        response.addHeader("trace", trace);
        response.addHeader("Your name", user.toParseName(user));
        response.addHeader("Your location", user.toParseLocation(user));
        response.addHeader("Your age", String.valueOf(user.toParseAge(user)));
        response.addHeader("Your message", user.toString()); //Передаём header сформированный в User.toString() из request

// Определяем какой JSON отправлять из 3х возможных
        time = (long) (Math.random() * ((3 + 1) - 1) + 1);
        System.out.println("Random JSON number - " + time);

        switch ((int) time) {
            case  (1):
                responseJSON = "{\n" +
                        "\t\"name\": \"" + user.toParseName(user)+"\",\n" +
                        "\t\"city\": \"" + user.toParseLocation(user)+"\",\n" +
                        "\t\"age\": " + String.valueOf(user.toParseAge(user))+" \n" +
                        "\t\"trace\": " + trace+" \n" +
                        "}";
                break;
            case (2):
                responseJSON = "{\n" +
                        "\t\"name\": \"" + user.toParseName(user)+"\",\n" +
                        "\t\"city\": \"" + user.toParseLocation(user)+"\",\n" +
                        "\t\"age\": " + String.valueOf(user.toParseAge(user))+" \n" +
                        "\t\"inn\": " + trace + trace+" \n" +
                        "}";
                break;
            case (3):
                responseJSON = "{\n" +
                        "\t\"name\": \"" + user.toParseName(user)+"\",\n" +
                        "\t\"city\": \"" + user.toParseLocation(user)+"\",\n" +
                        "\t\"age\": " + String.valueOf(user.toParseAge(user))+" \n" +
                        "}";
                break;
            default:
                responseJSON = "{\n" +
                        "\t\"Message\": \"" + "Random number for JSON is wrong" +"\",\n" +
                        "}";
                System.out.println("Random number for JSON is wrong");
                break;
        }

// Отправляем самостоятельно собранный JSON
        return responseJSON;
    }

// GET с inn в endpoint, возвращаем json

    @GetMapping("/inn/{inn}")
    public String getBodyId(@PathVariable String inn,
                            HttpServletResponse response) throws InterruptedException {

        time = (long) (Math.random() * (Integer.parseInt(timerMax) - Integer.parseInt(timerMin)) + Integer.parseInt(timerMin));
        System.out.println("Random Timer - " + time);
        Thread.sleep(time);

        response.addHeader("inn", inn);
        return String.format("{\n" +
                "\t\"name\": \"" + "IVAN"+"\",\n" +
                "\t\"city\": \"" + "Sochi"+"\",\n" +
                "\t\"age\": " + 23 +" \n" +
                "\t\"inn\": " + inn +" \n" +
                "}");
    }

    // GET с параметром и header

    @GetMapping("/inn")
    public String getBody(@RequestParam(value =  "inn", defaultValue = "33333") String inn,
                          @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                          HttpServletResponse response) throws InterruptedException {

        time = (long) (Math.random() * (Integer.parseInt(timerMax) - Integer.parseInt(timerMin)) + Integer.parseInt(timerMin));
        System.out.println("Random Timer - " + time);
        Thread.sleep(time);

        response.addHeader("trace", trace);
        return String.format("Your inn - %s! Your trace - %s", inn, trace+trace);
    }

}
