package ru.server.mock.bankCard;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.server.mock.myTimer.MyTimer;

import static ru.server.mock.bankCard.client.GetToken.getToken;
import static ru.server.mock.bankCard.client.PostToken.postToken;

// Сервер + Клиент для получения токена от SpringBootGetToken

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


        //парсим номер карты
        String num = bankCard.toParseNumber();
        System.out.println("bank card number - " + num);
        //запрашиваем токен передавая номер карты, готово два метода для запроса токена GET getToken и POSt postToken
        String strToken = getToken(num);
        System.out.println("Token - " + strToken);
        //формирем response с токеном
        Token token = new Token();
        token.setToken(strToken);

        // Отправляем полученный JSON с токеном
        return token.toString() ;   //bankCard.toString();
    }
}
