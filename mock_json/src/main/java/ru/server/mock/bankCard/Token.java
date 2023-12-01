package ru.server.mock.bankCard;

import org.springframework.web.reactive.function.client.WebClient;

public class Token {
    String token;
    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "{" +
                "token='" + token + '\'' +
                '}';
    }


    public String getToken(String num) {
        String url = "localhost:7777";

        WebClient.Builder builder = WebClient.builder();

        Token token = builder.build()
                .post()
                .uri(url)
                .retrieve()
                .bodyToMono(Token.class)
                .block();

        System.out.println("--------------");
        System.out.println(token);
        System.out.println("--------------");
        return token.toString();


    }
}
