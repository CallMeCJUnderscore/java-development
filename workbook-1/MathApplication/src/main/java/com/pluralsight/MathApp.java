package com.pluralsight;
import java.util.Arrays;
public class MathApp {
    public static void main(String[] args) {
        double bobSalary = 123;
        double garySalary = .5;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("When comparing Bob's salary of $" + bobSalary + " and Gary's salary of $" + garySalary + ", the highest salary is $" + highestSalary + ".");

        double carPrice = 5000;
        double truckPrice = 10000;
        double lowestPrice = Math.min(carPrice, truckPrice);
        System.out.println("\nWhen comparing the price of a car ($" + carPrice + ") and the price of a truck ($" + truckPrice + "), the lower price is $" + lowestPrice + ".");

        double radius = 7.25;
        double circleArea = radius * radius * Math.PI;
        System.out.println("\nGiven a circle's radius of " + radius + ", the area of that circle is " + circleArea + ".");

        double findMyRoot = 5.0;
        System.out.println("\nThe square root of " + findMyRoot + " is " + Math.sqrt(findMyRoot) + ".");

        int[] point1 = {5, 10};
        int[] point2 = {85, 50};
        int horizontalDiff = Math.abs(point2[0] - point1[0]);
        int verticalDiff = Math.abs(point2[1] - point1[1]);
        double horizontalSquared = Math.pow(horizontalDiff, 2);
        double verticalSquared = Math.pow(verticalDiff, 2);
        double pointDistance = Math.sqrt(horizontalSquared + verticalSquared);

        System.out.println("\nPoint 1 is at coordinates " + Arrays.toString(point1) + ", and Point 2 is at coordinates " + Arrays.toString(point2) + ".");
        System.out.println("Given these two coordinates, the distance between them is " + pointDistance + ".");

        double findMyAbs = -3.8;
        System.out.println("\nGiven a value of " + findMyAbs + ", the absolute value of it would be " + Math.abs(findMyAbs) + ".");

        System.out.println("\nHere's a random number somewhere between 0 and 1: " + Math.random() + ".");

    }
}
