package com.pluralsight;

public class Guest {

    /*---------------VARIABLES---------------*/

    private String name;
    private int age;
    private boolean isCheckedIn;
    /*--------------CONSTRUCTORS-------------*/

    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
        isCheckedIn=false;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    /*---------------FUNCTIONS---------------*/

    public void checkIn(){
        isCheckedIn=true;
    }

    public void checkOut(){
        isCheckedIn=false;
    }
}
