package com.Card;

public class Main {
    public static void main(String[] args) {
        Deck d1 = new Deck();


        System.out.println("Random Cards");
        System.out.println();
        d1.random();

        System.out.println();
        System.out.println();

        System.out.println("Simple Cards");
        System.out.println();
        System.out.println(d1);
    }
}
