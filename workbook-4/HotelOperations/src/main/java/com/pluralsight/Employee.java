package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    public double clockInTime;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        hoursWorked = 0;
        clockInTime = 0;
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
            clockInTime = time;
        }
    }
    public void punchIn(){
        LocalDateTime now = LocalDateTime.now();
        double hours = now.getHour();
        double minutes = now.getMinute() / 60.0;
        clockInTime = hours+minutes;
    }
    public void punchOut(double time){
        if (time < 0.0 || time > 24.0){
            System.out.println("ERROR: TIME OUT OF VALID RANGE");
        }
        else {
            if (time> clockInTime){
                hoursWorked += (time - clockInTime);
                clockInTime = 0.0;
            }
            else if (clockInTime == 0.0){
                System.out.println("ERROR: YOU HAVE NOT YET CLOCKED IN");
            }
            else{
                System.out.println("ERROR: CLOCK OUT TIME BEFORE CLOCK IN TIME");
            }
        }
    }
    public void punchOut(){
        LocalDateTime now = LocalDateTime.now();
        double hours = now.getHour();
        double minutes = now.getMinute() / 60.0;
        double time = hours+minutes;
        if (time> clockInTime){
            hoursWorked += (time - clockInTime);
            clockInTime = 0.0;
        }
        else if (clockInTime == 0.0){
            System.out.println("ERROR: YOU HAVE NOT YET CLOCKED IN");
        }
        else{
            System.out.println("ERROR: CLOCK OUT TIME BEFORE CLOCK IN TIME");
        }
    }

    public void punchTimeCard(double time){
        if (clockInTime == 0){
            if (time < 0.0 || time > 24.0){
                System.out.println("ERROR: TIME OUT OF VALID RANGE");
            }
            else {
                if (time> clockInTime){
                    hoursWorked += (time - clockInTime);
                    clockInTime = 0.0;
                }
                else{
                    System.out.println("ERROR: CLOCK OUT TIME BEFORE CLOCK IN TIME");
                }
            }
        }
        else{
            if (time < 0.0 || time > 24.0){
                System.out.println("ERROR: TIME OUT OF VALID RANGE");
            }
            else {
                if (time > clockInTime) {
                    hoursWorked += (time - clockInTime);
                    clockInTime = 0.0;
                } else {
                    System.out.println("ERROR: CLOCK OUT TIME BEFORE CLOCK IN TIME");
                }
            }
        }
    }
}