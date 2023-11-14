package com.pluralsight;

public class Staff {
    /*---------------VARIABLES---------------*/

    private String name;
    private String position;
    private String id;

    /*--------------CONSTRUCTORS-------------*/

    public Staff(String name, String position, String id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    /*---------------FUNCTIONS---------------*/

    public String performDuty(String dutyDescription){
        return name + "is performing duty: " + dutyDescription;
    }
}
