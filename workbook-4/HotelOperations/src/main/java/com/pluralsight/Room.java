package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = false;
        this.isDirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public void checkIn(){
        if (isOccupied == true || isDirty == true){
            System.out.println("ERROR: ROOM IS NOT SUITABLE FOR USE");
        }
        else{
            System.out.println("ROOM CHECKED IN!");
            isDirty = true;
            isOccupied = true;
        }
    }

    public void checkOut(){
        if (isOccupied == false){
            System.out.println("ERROR: ROOM ALREADY UNOCCUPIED");
        }
        else{
            isOccupied = false;
            System.out.println("ROOM CHECKED OUT!");
        }
    }

    public void cleanRoom(){
        if (isDirty == false){
            System.out.println("ERROR: ROOM ALREADY CLEAN");
        }
        else{
            isDirty = false;
            System.out.println("ROOM CLEANED!");
        }
    }
}
