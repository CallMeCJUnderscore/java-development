package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        StringBuilder billing = new StringBuilder();
        StringBuilder shipping = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        //begin gather data
        System.out.println("Please provide the following information:");
        System.out.print("Full name: ");
        String input = scanner.nextLine();
        String name = input;
        System.out.print("\nBilling Street: "); //gather billing info
        input = scanner.nextLine().trim();
        billing.append(input);
        System.out.print("Billing City: ");
        input = scanner.nextLine().trim();
        billing.append("|"+input);
        System.out.print("Billing State: ");
        input = scanner.nextLine().trim();
        billing.append("|"+input);
        System.out.print("Billing ZIP Code: ");
        input = scanner.nextLine().trim();
        billing.append("|"+input);

        System.out.print("\nShipping Street: "); //gather shipping info
        input = scanner.nextLine().trim();
        shipping.append(input);
        System.out.print("Shipping City: ");
        input = scanner.nextLine().trim();
        shipping.append("|"+input);
        System.out.print("Shipping State: ");
        input = scanner.nextLine().trim();
        shipping.append("|"+input);
        System.out.print("Shipping ZIP: ");
        input = scanner.nextLine().trim();
        shipping.append("|"+input);

        //start print info
        int separatorIndex = billing.indexOf("|");
        String output = billing.substring(0, separatorIndex);
        billing.delete(0, separatorIndex+1);

        //print name
        System.out.println("\n Full name: " + name);

        //print billing info
        System.out.println("\n Billing Street: " + output);
        separatorIndex = billing.indexOf("|");
        output = billing.substring(0, separatorIndex);
        billing.delete(0, separatorIndex+1);
        System.out.println("Billing City: " + output);
        separatorIndex = billing.indexOf("|");
        output = billing.substring(0, separatorIndex);
        billing.delete(0, separatorIndex+1);
        System.out.println("Billing State: " + output);
        output = billing.toString();
        System.out.println("Billing ZIP: " + output);

        //print shipping info
        separatorIndex = shipping.indexOf("|");
        output = shipping.substring(0, separatorIndex);
        shipping.delete(0, separatorIndex+1);
        System.out.println("\nShipping Street: " + output);
        separatorIndex = shipping.indexOf("|");
        output = shipping.substring(0, separatorIndex);
        shipping.delete(0, separatorIndex+1);
        System.out.println("Shipping City: " + output);
        separatorIndex = shipping.indexOf("|");
        output = shipping.substring(0, separatorIndex);
        shipping.delete(0, separatorIndex+1);
        System.out.println("Shipping State: " + output);
        output = shipping.toString();
        System.out.println("Shipping ZIP: " + output);

    }
}
