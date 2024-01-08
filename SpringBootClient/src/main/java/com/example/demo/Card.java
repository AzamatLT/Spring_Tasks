package com.example.demo;

public class Card {

        private String number;

        public Card(String number) {
        }

        public String getCard() {
                return number;
        }

        public void setCard(String number) {
                this.number = number;
        }




        @Override
        public String toString() {
                return "Card{" +
                        "number='" + number + '\'' +
                        '}';
        }
}
