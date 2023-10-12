package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {

    public static void display(CellPhone phone){
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Phone Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }

    public static void main(String[] args) {

        //initialize
        CellPhone myPhone = new CellPhone();
        CellPhone myOtherPhone = new CellPhone();
        CellPhone myFinalPhone = new CellPhone(1234,"Overload","OverCarrier", "999-999-9999", "Overload Man");
        Scanner scanner = new Scanner(System.in);

        //set first phone variables
        System.out.println("Setting first phone...");
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

        //set second phone variables
        System.out.println("\nSetting second phone...");
        System.out.print("What is the serial number? ");
        myOtherPhone.setSerialNumber(scanner.nextLong());
        scanner.nextLine(); //clear scanner

        System.out.print("What is the phone's model? ");
        myOtherPhone.setModel(scanner.nextLine());

        System.out.print("Who is the phone's carrier? ");
        myOtherPhone.setCarrier(scanner.nextLine());

        System.out.print("What is the phone number? ");
        myOtherPhone.setPhoneNumber(scanner.nextLine());

        System.out.print("Who owns this phone? ");
        myOtherPhone.setOwner(scanner.nextLine());

        //print variables
        System.out.println("\n");
        display(myPhone);
        System.out.println();
        display(myOtherPhone);
        System.out.println();
        display(myFinalPhone);
        System.out.println("\n");
        myPhone.dial(myOtherPhone.getPhoneNumber());
        myOtherPhone.dial(myPhone.getPhoneNumber());
        myPhone.dial(myFinalPhone.getPhoneNumber());
        myOtherPhone.dial(myFinalPhone);

    }
}
