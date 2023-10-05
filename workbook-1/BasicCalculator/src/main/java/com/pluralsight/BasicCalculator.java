package com.pluralsight;
import java.util.Scanner;

public class BasicCalculator {

    static Scanner scanner = new Scanner(System.in);
    public static void initialize(){
        float num1 = 0.0f;
        float num2 = 0.0f;
        String operation;
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
        operation = operation.substring(0,1).toUpperCase();
        calculate(num1, num2, operation);
    }
    public static void calculate(float num1, float num2, String operation){
        float answer = 0.0f;
        switch (operation) {
            case "A":
                answer = num1 + num2;
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
                if(num2 == 0) {System.out.println("ERROR: You can't divide by zero!");}
                else{
                    answer = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + answer);
                }
                break;
            default:
                System.out.println("ERROR: Unsupported Operation");
        }
    }

    public static void main(String[] args) {
        initialize();
        return;
    }

}
