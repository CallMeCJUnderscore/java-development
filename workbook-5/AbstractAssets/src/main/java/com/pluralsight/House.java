package com.pluralsight;

public class House extends Asset{
    /*---------------VARIABLES---------------*/

    String address;
    int condition;
    int squareFoot;
    int lotSize;

    /*--------------CONSTRUCTORS-------------*/

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    /*---------------FUNCTIONS---------------*/

    public double getValue(){
        return switch (condition) {
            case 1 -> (180.0 * getSquareFoot()) + (getLotSize() * .25);
            case 2 -> (130.0 * getSquareFoot()) + (getLotSize() * .25);
            case 3 -> (90.0 * getSquareFoot()) + (getLotSize() * .25);
            case 4 -> (80.0 * getSquareFoot()) + (getLotSize() * .25);
            default -> 0.0;
        };
    }
}
