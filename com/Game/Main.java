package com.Game;

public class Main {
    public static void main(String[] args) {
        Player1 player = new Player1("Ali Hassan" , "Sword" , 400);
//        System.out.println(player.getName());
//        System.out.println(player.getHealth());
//        System.out.println(player.getWeapon());

//        player.damageByGun1();
//        player.damageByGun1();
//        player.damageByGun2();

        Player2 player2 = new Player2("Ali" , "AK47" , 80 , true);
        player2.damageByGun1();
    }
}
