package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static boolean isStringOnlyAlphabet(String str)
    {

        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }
    public static String buildFullName(String firstName, String middleName, String lastName, String suffix){


        firstName = firstName.toUpperCase().substring(0,1) + firstName.toLowerCase().substring(1);
        middleName = middleName.toUpperCase().substring(0,1) + middleName.toLowerCase().substring(1);
        lastName = lastName.toUpperCase().substring(0,1) + lastName.toLowerCase().substring(1);

        firstName += " ";
        suffix = ", " + suffix;

        if (middleName.equalsIgnoreCase("NONE")){
            middleName = "";
        }
        if (suffix.equalsIgnoreCase(", NONE")){
            suffix = "";
        }
        middleName+=(middleName.length()==1) ? ". " : " ";
        String fullName = firstName + middleName + lastName + suffix;

        return fullName;
    }
    public static void main(String[] args) {
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";

        Scanner scanner = new Scanner(System.in);

        while (firstName == ""){
            System.out.print("Please type your first name: ");
            firstName = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(firstName)){
                System.out.println("ERROR: Name can only contain letters.");
                firstName = "";
            }
        }

        while (middleName == "" || !middleName.equalsIgnoreCase("NONE")){
            System.out.print("Please type your middle name (Type NONE if none): ");
            middleName = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(middleName)){
                System.out.println("ERROR: Name can only contain letters.");
                middleName = "";
            }
        }

        while (lastName == ""){
            System.out.print("Please type your last name: ");
            lastName = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(lastName)){
                System.out.println("ERROR: Name can only contain letters.");
                lastName = "";
            }
        }

        while (suffix == "" || !suffix.equalsIgnoreCase("NONE")){
            System.out.print("Please type your suffix, if any (Type NONE if none): ");
            suffix = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(suffix)){
                System.out.println("ERROR: Name can only contain letters.");
                suffix = "";
            }
        }


        String fullName = buildFullName(firstName, middleName, lastName, suffix);
        System.out.println("Your full name is: " + fullName);
    }
}
