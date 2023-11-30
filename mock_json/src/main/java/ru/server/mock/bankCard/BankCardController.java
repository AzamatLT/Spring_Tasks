package ru.server.mock.bankCard;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.server.mock.bankCard.client.Token;
import ru.server.mock.myTimer.MyTimer;

// Сервер + Клиент для получения токена

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class BankCardController {

    private final int timerMin;
    private final int timerMax;


    @Autowired
    public BankCardController(@Value("${timerBankCard.min}") int timerMin, @Value("${timerBankCard.max}") int timerMax) {
        this.timerMin = timerMin;
        this.timerMax = timerMax;
        log.warn(" timerBankCardMin = " + timerMin + "  timerBankCardMax = " + timerMax);
    }



    @PostMapping("/bankcard")
    @ResponseBody
    public String publishtUser(@RequestBody BankCard bankCard,
                               HttpServletResponse response) {
        MyTimer.myTimer(timerMin, timerMax);
        log.warn("Print BankCard Object " + bankCard);
// Парсим JSON
       // response.addHeader("token", token);
     //   response.addHeader("Your name", bankCard.toParseName(bankCard));
     //   response.addHeader("Your number", bankCard.toParseNumber(bankCard));
     //   response.addHeader("Your date", String.valueOf(bankCard.toParseDate(bankCard)));
      //  response.addHeader("Your bankCard", bankCard.toString()); //Передаём header сформированный в bankCard.toString() из request
// Отправляем полученный JSON
        String num = bankCard.toParseNumber();
        System.out.println("bank card number = " + num);
        Token token = new Token();
        System.out.println("token = " + token);

        return token.getToken(num) ;   //bankCard.toString();
    }





}
