package com.pluralsight.finance;

public class Jewelry extends FixedAsset{
    /*---------------VARIABLES---------------*/

    private double karat;

    /*--------------CONSTRUCTORS-------------*/

    public Jewelry(String name, double value, double karat) {
        super(name, value);
        this.karat = karat;
    }

    /*------------GETTERS/SETTERS------------*/

    public double getKarat() {
        return karat;
    }

    public void setKarat(double karat) {
        this.karat = karat;
    }

    /*---------------FUNCTIONS---------------*/

    @Override
    public String toString() {
        return "Jewelry{" +
                "karat=" + karat +
                '}';
    }

    @Override
    public double getValue() {
        return karat * value;
    }
}
