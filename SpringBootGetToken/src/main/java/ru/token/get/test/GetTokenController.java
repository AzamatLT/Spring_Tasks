package ru.token.get.test;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;




@Slf4j
@RestController
@RequestMapping("/api/v1")
public class GetTokenController {


    @PostMapping("/gettoken")
    @ResponseBody
    public String postToken(@RequestBody Token token,
                               HttpServletResponse postResponse) {

        System.out.println(token.toParseCard(token));
        token.setToken(token.toParseCard(token)+token.toParseCard(token));


        return token.toString();
    }

    @GetMapping("/gettoken")
    public String getToken(@RequestParam(value = "number", defaultValue = "0000") String cardNumber,
                              @RequestHeader(value =  "trace", defaultValue = "111111") String trace,
                              HttpServletResponse response) {

        System.out.println("cardNumber = " + cardNumber);
        response.addHeader("trace", trace);
        // return new Greeting(counter.incrementAndGet(), String.format(templateName, name), String.format(templateGreeting, greeting));
        return cardNumber + cardNumber;
    }



}

