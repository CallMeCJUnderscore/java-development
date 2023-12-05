package com.pluralsight.finance;

public abstract class FixedAsset implements IValuable {
    /*---------------VARIABLES---------------*/

    protected String name;
    protected double value;

    /*--------------CONSTRUCTORS-------------*/

    public FixedAsset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /*---------------FUNCTIONS---------------*/
}
