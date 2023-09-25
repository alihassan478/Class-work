package com.Idcount;

public class Main {
    public static void main(String[] args) {
        Products p1 = new Products("Laptop",4,200000);
        Products p2 = new Products("Headphones",2,5000);
        Products p3 = new Products("Mouse" ,5,1000);

        System.out.println(Products.head());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p1.clone(p2));
    }
}
