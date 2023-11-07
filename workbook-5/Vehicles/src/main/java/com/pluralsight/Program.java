package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        Moped slowRide = new Moped();
        slowRide.setColor("Red");
        slowRide.setFuelCapacity(5);


        SemiTruck smokeyAndTheBandit = new SemiTruck();
        smokeyAndTheBandit.setNumberOfPassengers(2);

        Car herbie = new Car();
        herbie.setFuelCapacity(2);

        Hovercraft landSpeeder = new Hovercraft();
        landSpeeder.setColor("White");
        }
}
