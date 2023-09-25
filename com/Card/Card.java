package com.Card;

public class Card {
    final String suits;

    final String rank;

    public Card(String suits, String rank) {
        this.suits = suits;
        this.rank = rank;
    }

    public String getSuits() {
        return suits;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%s of %s" , rank,suits);
    }
}
