package com.pluralsight;

public class Hovercraft extends Vehicle{
    /*---------------VARIABLES---------------*/

    int airCushionPressure;

    /*--------------CONSTRUCTORS-------------*/

    public Hovercraft(String model, String color, int topSpeed, int fuelCapacity, int numberOfPassengers, int cargoCapacity, int airCushionPressure) {
        super(model, color, topSpeed, fuelCapacity, numberOfPassengers, cargoCapacity);
        this.airCushionPressure = airCushionPressure;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getAirCushionPressure() {
        return airCushionPressure;
    }

    public void setAirCushionPressure(int airCushionPressure) {
        this.airCushionPressure = airCushionPressure;
    }

    /*---------------FUNCTIONS---------------*/

    public void hover(){
        System.out.println("Hovercraft hover");
    }
}
