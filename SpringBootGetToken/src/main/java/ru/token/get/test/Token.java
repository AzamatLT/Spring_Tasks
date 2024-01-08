package ru.token.get.test;
public class Token {
    String token;
    String card;
    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", card='" + card + '\'' +
                '}';
    }

    public String toParseCard(Token token) {
        String card = this.card;
        return card;
    }
}
