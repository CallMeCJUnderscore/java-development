package com.pluralsight;

public class Room {

    /*---------------VARIABLES---------------*/

    private int roomNumber;
    private String roomType;
    private boolean isOccupied;

    /*--------------CONSTRUCTORS-------------*/

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        isOccupied = false;
    }

    /*------------GETTERS/SETTERS------------*/

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    /*---------------FUNCTIONS---------------*/

    public boolean bookRoom(){
        if(!isOccupied){
            Hotel.increaseTotalBookings(1);
            isOccupied = true;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean bookRoom(Guest guest){
        if(!isOccupied){
            Hotel.increaseTotalBookings(1);
            guest.checkIn();
            isOccupied = true;
            return true;
        }
        else{
            return false;
        }
    }

    public void vacateRoom(){
        Hotel.decreaseTotalBookings(1);
        isOccupied = false;
    }
    public void vacateRoom(Guest guest){
        Hotel.decreaseTotalBookings(1);
        guest.checkOut();
        isOccupied = false;
    }
}
