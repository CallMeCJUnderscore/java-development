package com.pluralsight;

public class Cash extends Asset{
    /*---------------VARIABLES---------------*/

    double amount;

    /*--------------CONSTRUCTORS-------------*/

    public Cash(String description, String dateAcquired, double originalCost, int amount) {
        super("The cash stash", "When I got it", 0.0);
        this.amount = amount;
    }

    /*------------GETTERS/SETTERS------------*/

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /*---------------FUNCTIONS---------------*/

    public void stash(int amount){
        this.amount += amount;
    }

    public void remove(int amount){
        this.amount -= amount;
    }
    public double getValue(){
        return amount * 100.0;
    }
}
