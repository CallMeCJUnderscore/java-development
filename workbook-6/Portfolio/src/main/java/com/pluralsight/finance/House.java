package com.pluralsight.finance;

public class House extends FixedAsset{
    /*---------------VARIABLES---------------*/

    private int yearBuilt;
    private int sqareFeet;
    private int bedrooms;


    /*--------------CONSTRUCTORS-------------*/

    public House(String name, double value, int yearBuilt, int sqareFeet, int bedrooms) {
        super(name, value);
        this.yearBuilt = yearBuilt;
        this.sqareFeet = sqareFeet;
        this.bedrooms = bedrooms;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getSqareFeet() {
        return sqareFeet;
    }

    public void setSqareFeet(int sqareFeet) {
        this.sqareFeet = sqareFeet;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /*---------------FUNCTIONS---------------*/

    @Override
    public double getValue() {
        return super.getValue();
    }
}
