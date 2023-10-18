package com.pluralsight;

public class Product {



    /*---------------VARIABLES---------------*/

    private int id;
    private String name;
    private float price;

    /*--------------CONSTRUCTORS-------------*/

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public float getPrice() {
        return this.price;
    }

    /*---------------FUNCTIONS---------------*/
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
