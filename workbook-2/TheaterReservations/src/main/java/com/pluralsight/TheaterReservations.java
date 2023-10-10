package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {

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
            if(separator == -1){
                System.out.println("ERROR: Invalid Name Format.");
                continue;
            }
            firstName = name.substring(0,separator);
            lastName = name.substring(separator+1);
            firstName = firstName.toUpperCase().substring(0,1) + firstName.toLowerCase().substring(1);
            lastName = lastName.toUpperCase().substring(0,1) + lastName.toLowerCase().substring(1);
            break;
        }
        System.out.print("Please type the date of your preferred reservation: ");
        LocalDate reservation = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("How many tickets would you like to reserve? ");
        quantity=scanner.nextInt();

        System.out.print(quantity + ((quantity==1)?" ticket ":" tickets ") + "reserved for " + reservation + " under " +  lastName + ", " + firstName + ".");

    }
}
