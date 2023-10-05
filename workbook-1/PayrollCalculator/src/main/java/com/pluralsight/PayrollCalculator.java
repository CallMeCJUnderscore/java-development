package com.pluralsight;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        float hoursWorked;
        float payRate;
        float grossPay;

        System.out.print("Please type your name: ");
        name = scanner.nextLine();
        System.out.print("Please type your number of hours worked this week: ");
        hoursWorked = scanner.nextFloat();
        System.out.print("Please type your hourly pay rate: ");
        payRate = scanner.nextFloat();

        name.toLowerCase();
        name= name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        grossPay = payRate * hoursWorked;
        if(hoursWorked > 40.0f){
            float overtimeHours = hoursWorked - 40.0f;
            float overtimePay = overtimeHours * (payRate * 1.5f);
            grossPay += overtimePay;
        }
        System.out.printf("%s, your gross pay for this week is $%.2f", name, grossPay);
    }
}
