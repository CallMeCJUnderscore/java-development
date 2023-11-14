package com.pluralsight;

public class Hotel {
    /*---------------VARIABLES---------------*/

    private static int totalBookings = 0;

    /*--------------CONSTRUCTORS-------------*/

    //CODE HERE

    /*------------GETTERS/SETTERS------------*/

    //CODE HERE

    /*---------------FUNCTIONS---------------*/

    public static int getTotalBookings(){
        return totalBookings;
    }

    public static void increaseTotalBookings(int amount){
        totalBookings += amount;
    }

    public static void decreaseTotalBookings(int amount){
        totalBookings -= amount;
    }
}
