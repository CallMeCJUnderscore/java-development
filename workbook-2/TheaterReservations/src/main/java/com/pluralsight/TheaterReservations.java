package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static boolean isStringOnlyAlphabet(String str) {
        return str.matches("^[a-zA-Z]*$");
    }
    public static void main(String[] args) {
        String name;
        String firstName;
        String lastName;
        int quantity;
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Please type your name: ");
            name = scanner.nextLine();
            int separator = name.indexOf(" ");
            if(separator == -1 || !isStringOnlyAlphabet(name)){
                System.out.println("ERROR: Invalid Name Format. Must be two words, and only letters.");
                continue;
            }
            firstName = name.substring(0,separator);
            lastName = name.substring(separator);
            break;
        }
        System.out.print("Please type the date of your preferred reservation: ");
        LocalDate reservation = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("How many tickets would you like to reserve? ");
        quantity=scanner.nextInt();

        System.out.print(quantity + " tickets reserved for " + reservation + " under " +  lastName + ", " + firstName + ".");

    }
}
