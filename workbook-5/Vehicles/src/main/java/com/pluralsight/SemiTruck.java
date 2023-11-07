package com.pluralsight;

public class SemiTruck extends Vehicle{
    /*---------------VARIABLES---------------*/

    int numberOfTrailers;

    /*--------------CONSTRUCTORS-------------*/

    public SemiTruck(String model, String color, int topSpeed, int fuelCapacity, int numberOfPassengers, int cargoCapacity, int numberOfTrailers) {
        super(model, color, topSpeed, fuelCapacity, numberOfPassengers, cargoCapacity);
        this.numberOfTrailers = numberOfTrailers;
    }

    //CODE HERE

    /*------------GETTERS/SETTERS------------*/

    public int getNumberOfTrailers() {
        return numberOfTrailers;
    }

    public void setNumberOfTrailers(int numberOfTrailers) {
        this.numberOfTrailers = numberOfTrailers;
    }

    /*---------------FUNCTIONS---------------*/

    public void loadCargo(){
        System.out.println("Semi Load Cargo");
    }

    public void unloadCargo(){
        System.out.println("Semi Unload Cargo");
    }
}
