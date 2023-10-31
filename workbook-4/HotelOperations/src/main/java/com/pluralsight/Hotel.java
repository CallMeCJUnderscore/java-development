package com.pluralsight;

public class Hotel {
    /*---------------VARIABLES---------------*/

    String name;
    int numberOfSuites;
    int numberOfRooms;
    int bookedSuites;
    int bookedRooms;

    /*--------------CONSTRUCTORS-------------*/

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        bookedRooms = 0;
        bookedSuites = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedRooms;
    }

    /*---------------FUNCTIONS---------------*/

    public boolean bookRoom(int numberOfRooms, boolean isSuite){
        if (isSuite){
            if(getAvailableSuites() >= numberOfRooms){
                bookedSuites += numberOfRooms;
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(getAvailableRooms() >= numberOfRooms){
                bookedRooms += numberOfRooms;
                return true;
            }
            else{
                return false;
            }
        }
    }
}
