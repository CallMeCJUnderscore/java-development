package com.pluralsight.models;

public class Actor {
    /*---------------VARIABLES---------------*/

    private int actorID;
    private String firstName;
    private String lastName;

    /*--------------CONSTRUCTORS-------------*/

    public Actor(int actorID, String firstName, String lastName) {
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*---------------FUNCTIONS---------------*/

    public void printInfo(){
        System.out.println("Actor ID: " + this.getActorID());
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("================================================");
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorID=" + actorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
