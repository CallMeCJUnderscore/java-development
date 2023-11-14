package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    /*---------------VARIABLES---------------*/

    String makeModel;
    int year;
    int odometer;

    /*--------------CONSTRUCTORS-------------*/

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /*---------------FUNCTIONS---------------*/

    public double getValue(){
        int currentYear = LocalDate.EPOCH.getYear();
        int age = currentYear - getYear();
        double value = getOriginalCost();
        if (age > 10) {value = 1000;}
        else if(age >=7){
            while (age > 0){
                value *= .92;
                age--;
            }
        }
        else if(age >= 4){
            while (age > 0){
                value *= .94;
                age--;
            }
        }
        else if (age >= 0){
            while (age > 0) {
                value *= 0.97;
                age--;
            }
        }
        if(getOdometer() > 100000 && (!getMakeModel().contains("Honda") || !getMakeModel().contains("Toyota"))){
            value *= .75;
        }
        return value;
    }
}
