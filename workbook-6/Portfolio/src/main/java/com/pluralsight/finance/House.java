package com.pluralsight.finance;

public class House extends FixedAsset{
    /*---------------VARIABLES---------------*/

    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;


    /*--------------CONSTRUCTORS-------------*/

    public House(String name, double value, int yearBuilt, int squareFeet, int bedrooms) {
        super(name, value);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /*---------------FUNCTIONS---------------*/

    @Override
    public String toString() {
        return "House{" +
                "yearBuilt=" + yearBuilt +
                ", squareFeet=" + squareFeet +
                ", bedrooms=" + bedrooms +
                '}';
    }

    @Override
    public double getValue() {
        return squareFeet * 100000;
    }
}
