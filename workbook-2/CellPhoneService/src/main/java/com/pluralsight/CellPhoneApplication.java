package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {

    public static void main(String[] args) {
        CellPhone myPhone = new CellPhone();
        Scanner scanner = new Scanner(System.in);

        //set variables
        System.out.print("What is the serial number? ");
        myPhone.setSerialNumber(scanner.nextLong());
        scanner.nextLine(); //clear scanner

        System.out.print("What is the phone's model? ");
        myPhone.setModel(scanner.nextLine());

        System.out.print("Who is the phone's carrier? ");
        myPhone.setCarrier(scanner.nextLine());

        System.out.print("What is the phone number? ");
        myPhone.setPhoneNumber(scanner.nextLine());

        System.out.print("Who owns this phone? ");
        myPhone.setOwner(scanner.nextLine());

        //print variables
        System.out.println("\n\nSerial Number: " + myPhone.getSerialNumber());
        System.out.println("Phone Model: " + myPhone.getModel());
        System.out.println("Carrier: " + myPhone.getCarrier());
        System.out.println("Phone Number: " + myPhone.getPhoneNumber());
        System.out.println("Owner: " + myPhone.getOwner());
    }
}
