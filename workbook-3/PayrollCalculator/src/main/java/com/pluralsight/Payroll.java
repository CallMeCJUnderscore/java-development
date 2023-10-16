package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class Payroll {


    public static void main(String[] args) {
        String fileName = "employees.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = bufferedReader.readLine())!=null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(id,name,hoursWorked,payRate);

                System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f%n", employee.getId(), employee.getName(), employee.getGrossPay());
            }

        } catch (Exception e) {
            System.out.println("An error occurred!");
        }
    }
}
