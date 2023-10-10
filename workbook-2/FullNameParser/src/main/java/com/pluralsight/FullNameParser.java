package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        String fullName;
        Scanner scanner = new Scanner(System.in);
        String firstName = "";
        String middleName = "";
        String lastName = "";

        System.out.print("Please type your full name: ");
        fullName = scanner.nextLine().trim();

        String[] parts = fullName.split(" ");

        parts[0] = parts[0].toUpperCase().substring(0,1) + parts[0].toLowerCase().substring(1);
        firstName = parts[0];

        if(parts.length == 3){
            parts[1] = parts[1].toUpperCase().substring(0,1) + parts[1].toLowerCase().substring(1);
            parts[2] = parts[2].toUpperCase().substring(0,1) + parts[2].toLowerCase().substring(1);
            middleName = parts[1];
            lastName = parts[2];
        }
        else if (parts.length == 2){
            parts[1] = parts[1].toUpperCase().substring(0,1) + parts[1].toLowerCase().substring(1);
            lastName = parts[1];
        }
        else {
            System.out.println("ERROR: Invalid Name format");
            return;
        }

        if (middleName.length()==1) {middleName+=".";}
        
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: "+ ((middleName.isEmpty())? "(NONE)" : middleName));
        System.out.println("Last name: " + lastName);
    }
}
