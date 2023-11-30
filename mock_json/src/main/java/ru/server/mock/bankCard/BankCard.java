package ru.server.mock.bankCard;

public class BankCard {


    private String name;

    private String number;

    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", date=" + date +
                '}';
    }

    public String toParseName(BankCard bankCard) {
        String name = this.name;
        return name;
    }
    public String toParseNumber() {
        String number = this.number;
        return number;
    }
    public String toParseDate(BankCard bankCard) {
        String date = this.date;
        return date;
    }

}
