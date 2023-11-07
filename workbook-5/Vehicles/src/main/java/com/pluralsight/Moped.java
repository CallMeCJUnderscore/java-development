package com.pluralsight;

public class Moped extends Vehicle{
    /*---------------VARIABLES---------------*/

    int maxWeight;

    /*--------------CONSTRUCTORS-------------*/

    public Moped(String model, String color, int topSpeed, int fuelCapacity, int numberOfPassengers, int cargoCapacity, int maxWeight) {
        super(model, color, topSpeed, fuelCapacity, numberOfPassengers, cargoCapacity);
        this.maxWeight = maxWeight;
    }


    /*------------GETTERS/SETTERS------------*/

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /*---------------FUNCTIONS---------------*/

    public void ride(){
        System.out.println("Moped Ride");
    }
}
