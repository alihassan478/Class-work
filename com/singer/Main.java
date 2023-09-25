package com.singer;

public class Main {
    public static void main(String[] args) {
        Music m1 = new Music("Faded", "3:00" , "Sad" , new Date(23,9,2016) , new Singer("Alan Walker" , "Male" , "American" , new Date(12,4,2010)));
        Music m2 = new Music("Faded", "3:00" , "Sad" , new Date(23,9,2016) , new Singer("Alan Walker" , "Male" , "American" , new Date(12,4,2010)));
        System.out.println(m2.equals(m1));
        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
    }
}
