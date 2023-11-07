package com.pluralsight;

public class Car extends Vehicle{
    /*---------------VARIABLES---------------*/

    int numberOfDoors;

    /*--------------CONSTRUCTORS-------------*/

    public Car(String model, String color, int topSpeed, int fuelCapacity, int numberOfPassengers, int cargoCapacity, int numberOfDoors) {
        super(model, color, topSpeed, fuelCapacity, numberOfPassengers, cargoCapacity);
        this.numberOfDoors = numberOfDoors;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /*---------------FUNCTIONS---------------*/

    public void openTrunk(){
        System.out.println("Car Open Trunk");
    }

    public void closeTrunk(){
        System.out.println("Car Close Trunk");
    }
}
