package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Payroll {

    public static void main(String[] args) {
        String employeeFile;
        String payrollFile;
        Scanner scanner = new Scanner(System.in);

        while (true) { //get filename
            System.out.print("Please type the name of the employee file to process: ");
            employeeFile = scanner.nextLine();
            if (!employeeFile.endsWith(".csv")){
                System.out.println("ERROR: File must in in .csv!");
            }
            else{break;}
        }

        while (true) { //get filename
            System.out.print("Please type the name of the payroll file to create: ");
            payrollFile = scanner.nextLine();
            if (!payrollFile.endsWith(".csv") && !payrollFile.endsWith(".json")){
                System.out.println("ERROR: File must in in .csv or .json!");
            }
            else{ break;}
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(employeeFile)); //create readers/writers
            FileWriter fileWriter = new FileWriter(payrollFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            String output;
            String fileType = (payrollFile.endsWith(".csv")?".csv":".json");

            if (fileType.equals(".csv")) { //csv file output
                bufferedWriter.write("id|name|gross pay\n"); //start of payroll file

                while ((line = bufferedReader.readLine()) != null) { //read employees
                    String[] tokens = line.split("\\|");
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double hoursWorked = Double.parseDouble(tokens[2]);
                    double payRate = Double.parseDouble(tokens[3]);

                    Employee employee = new Employee(id, name, hoursWorked, payRate);

                    output = employee.getId() + "|" + employee.getName() + "|" + employee.getGrossPay() + "\n"; //write to payroll file
                    bufferedWriter.write(output);
                }
            }
            else{ //json output
                bufferedWriter.write("[\n"); //start of payroll file

                while ((line = bufferedReader.readLine()) != null) { //read employees
                    String[] tokens = line.split("\\|");
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double hoursWorked = Double.parseDouble(tokens[2]);
                    double payRate = Double.parseDouble(tokens[3]);

                    Employee employee = new Employee(id, name, hoursWorked, payRate);

                    output = "\t{ \"id\": "+employee.getId() + ", \"name\" : \"" + employee.getName() + "\", \"grossPay\" : " + employee.getGrossPay() + " }\n"; //write to payroll file
                    if(bufferedReader.ready()) { //if there is another line
                        output=output.replace("}\n", "},\n");
                    }
                    bufferedWriter.write(output);
                }
                bufferedWriter.write("]");
            }
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("An error occurred!");
        }
    }
}
