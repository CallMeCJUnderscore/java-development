package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    public double clockIn;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        hoursWorked = 0;
        clockIn = 0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            return (40 * payRate) + ((hoursWorked - 40) * (payRate * 1.5));
        }
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }

    public void punchIn(double time){
        if (time < 0.0 || time > 24.0){
            System.out.println("ERROR: TIME OUT OF VALID RANGE");
        }
        else {
            clockIn = time;
        }
    }
    public void punchOut(double time){
        if (time < 0.0 || time > 24.0){
            System.out.println("ERROR: TIME OUT OF VALID RANGE");
        }
        else {
            if (time>clockIn){
                hoursWorked += (time - clockIn);
                clockIn = 0.0;
            }
            else if (clockIn == 0.0){
                System.out.println("ERROR: YOU HAVE NOT YET CLOCKED IN");
            }
            else{
                System.out.println("ERROR: CLOCK OUT TIME BEFORE CLOCK IN TIME");
            }
        }
    }

    public void punchTimeCard(double time){
        if (clockIn == 0){
            if (time < 0.0 || time > 24.0){
                System.out.println("ERROR: TIME OUT OF VALID RANGE");
            }
            else {
                if (time>clockIn){
                    hoursWorked += (time - clockIn);
                    clockIn = 0.0;
                }
                else{
                    System.out.println("ERROR: CLOCK OUT TIME BEFORE CLOCK IN TIME");
                }
            }
        }
        else{

        }
    }
}