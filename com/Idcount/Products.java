package com.Idcount;

public class Products {
    String name;

    int quantity;

    double price;

    int id;

    static int count=1;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Products(String name, int quantity, double price) {
        id = count++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return
                String.format("\n%-5d %-15s %-10d %-17.2f",
                        this.id, this.name, this.quantity, this.price);
    }

    public static String head() {
        return String.format("%-5s %-15s %-10s %-17s",
                "Id", "Product", "Quantity", "Price");
    }

    public Products clone(Products p1) {
        return new Products(this.name,this.quantity,(int) this.price);
    }
}
