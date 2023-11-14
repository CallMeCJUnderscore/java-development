package com.pluralsight.finance;

public class Gold extends FixedAsset{
    /*---------------VARIABLES---------------*/

    private double weight;

    /*--------------CONSTRUCTORS-------------*/

    public Gold(String name, double value, double weight) {
        super(name, value);
        this.weight = weight;
    }

    /*------------GETTERS/SETTERS------------*/

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*---------------FUNCTIONS---------------*/

    @Override
    public double getValue() {
        return super.getValue();
    }
}
