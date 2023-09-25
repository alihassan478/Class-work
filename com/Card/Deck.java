package com.Card;

import java.util.Arrays;

public class Deck {
    Card[] cards = new Card[52];

    String[] suits = {"Heart" , "Diamond" , "Spades" , "Clubs"};


    String[] rank = {"Ace","2","3","4","5","6","7","8","9","10","J","Q","K"};

    int counter = 0;
    Deck() {
        for (int i = 0; i<4;i++){
            for (int j =0; j<13;j++){
               cards[counter++] = new Card(suits[i] , rank[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i<52;i++){
            str.append(cards[i]).append("\n");
        }
        return str.toString();
    }
}
