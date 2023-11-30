package ru.server.mock.bankCard.client;

import org.springframework.web.reactive.function.client.WebClient;
public class GetToken {

    public static String getToken(String numberCard) {
        System.out.println("ddd");
        return numberCard;
    }
}
