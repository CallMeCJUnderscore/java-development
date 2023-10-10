package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class FullNameApplication {
    public static boolean isStringOnlyAlphabet(String str)
    {
        return str.equals("") || str.matches("^[a-zA-Z]*$");
    }
    public static String buildFullName(String firstName, String middleName, String lastName, String suffix){


        firstName = firstName.toUpperCase().substring(0,1) + firstName.toLowerCase().substring(1);
        lastName = lastName.toUpperCase().substring(0,1) + lastName.toLowerCase().substring(1);

        firstName += " ";

        if(!suffix.equals("")){
            suffix = ", " + suffix;
        }

        if(!middleName.equals("")){
            middleName = middleName.toUpperCase().substring(0,1) + middleName.toLowerCase().substring(1);
            middleName+=(middleName.length()==1) ? ". " : " ";
        }
        String fullName = firstName + middleName + lastName + suffix;

        return fullName;
    }
    public static void main(String[] args) {
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Please type your first name: ");
            firstName = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(firstName)){
                System.out.println("ERROR: Name can only contain letters.");
                continue;
            }
            break;
        }

        while (true){
            System.out.print("Please type your middle name: ");
            middleName = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(middleName)){
                System.out.println("ERROR: Name can only contain letters.");
                continue;
            }
            break;
        }

        while (true){
            System.out.print("Please type your last name: ");
            lastName = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(lastName)){
                System.out.println("ERROR: Name can only contain letters.");
                continue;
            }
            break;
        }

        while (true){
            System.out.print("Please type your suffix, if any: ");
            suffix = scanner.nextLine().trim();
            if(!isStringOnlyAlphabet(suffix)){
                System.out.println("ERROR: Name can only contain letters.");
                continue;
            }
            break;
        }


        String fullName = buildFullName(firstName, middleName, lastName, suffix);
        System.out.println("Your full name is: " + fullName);
    }
}
