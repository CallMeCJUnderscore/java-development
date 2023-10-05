package com.pluralsight;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        //initialize variables
        float num1 = 0.0f;
        float num2 = 0.0f;
        float answer = 0.0f;
        Scanner scanner = new Scanner(System.in);
        String operation;

        //begin calculator
        System.out.print("Enter the first number: ");
        num1 = scanner.nextFloat();
        System.out.print("Enter the second number: ");
        num2 = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("\n Please select an operation to perform. Your options are: ");
        System.out.println("            (A)dd");
        System.out.println("            (M)ultiply");
        System.out.println("            (S)ubtract");
        System.out.println("            (D)ivide");
        System.out.print("Which operation would you like to perform? ");
        operation = scanner.nextLine();
        operation = operation.toUpperCase();
        operation = operation.substring(0,1);
        switch (operation) {
            case "A":
                answer = num1 + num2;
               // System.out.printf("%5g + %.0g = %g\n", num1, num2, answer); HOW DOES THIS WORK AAAAAAAAAAAAAA
                System.out.println(num1 + " + " + num2 + " = " + answer);
                break;
            case "M":
                answer = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + answer);
                break;
            case "S":
                answer = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + answer);
                break;
            case "D":
                answer = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + answer);
                break;
            default:
                System.out.println("ERROR: Unsupported Operation");
        }
        return;
    }

}
