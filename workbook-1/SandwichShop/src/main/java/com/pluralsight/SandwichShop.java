package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        final double REGULAR_PRICE = 5.45;
        final double LARGE_PRICE = 8.95;
        final double REGULAR_LOADED = 1.0;
        final double LARGE_LOADED = 1.75;
        final double STUDENT_DISCOUNT = .9;
        final double SENIOR_DISCOUNT = .8;
        String loaded = "";
        int age = 0;
        int size = 0;
        Scanner scanner = new Scanner(System.in);
        double sale = 0.0;

        System.out.print("Please select a sandwich size (1=Regular, 2=Large): ");
        size = scanner.nextInt();
        sale = (size == 1) ? REGULAR_PRICE : LARGE_PRICE;

        System.out.print("Would you like the sandwich loaded? (Y or N): ");
        scanner.nextLine();
        loaded = scanner.nextLine();
        loaded = loaded.substring(0,1).toUpperCase();
        if(loaded.equals("Y")){sale += (size == 1) ? REGULAR_LOADED : LARGE_LOADED;}

        System.out.print("Please enter your age: ");
        age = scanner.nextInt();
        if (age <= 17) {
            sale *= STUDENT_DISCOUNT;
        } else if (age >= 65) {
            sale *= SENIOR_DISCOUNT;
        }

        System.out.printf("The cost of your sandwich is: $%.2f", sale);
    }
}
