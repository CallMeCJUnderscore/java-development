package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void punchIn_TimeTooLarge_Error() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);

        /*--------------ACT-------------*/
        employee.punchIn(25);

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 0);

    }

    @Test
    public void punchIn_TimeTooSmall_Error() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);

        /*--------------ACT-------------*/
        employee.punchIn(-1);

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 0);

    }

    @Test
    public void punchIn_TimeInRange_Success() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);

        /*--------------ACT-------------*/
        employee.punchIn(14);

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 14);

    }

    @Test
    public void punchIn_CalledUsingDateTime_Success() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);

        LocalDateTime now = LocalDateTime.now();
        double hours = now.getHour();
        double minutes = now.getMinute() / 60.0;
        double timeToCheck = hours+minutes;

        /*--------------ACT-------------*/
        employee.punchIn();

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, timeToCheck);

    }

    @Test
    public void punchOut_BeforeIn_Error() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);

        /*--------------ACT-------------*/
        employee.punchOut();

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 0);

    }

    @Test
    public void punchOut_HoursCalculation_Success() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);
        employee.punchIn(1);

        /*--------------ACT-------------*/
        employee.punchOut(2);

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 0);
        assertEquals(employee.getHoursWorked(), 1);
    }

    @Test
    public void punchOut_ManualEntryFromUser_Success() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);
        employee.punchIn(12);

        /*--------------ACT-------------*/
        employee.punchOut(14);

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 0);
        assertEquals(employee.getHoursWorked(), 2);
    }

    @Test
    public void punchOut_UserTimeTooLarge_Error() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);
        employee.punchIn(1);

        /*--------------ACT-------------*/
        employee.punchOut(25);

        /*------------ASSERT------------*/
        assertEquals(employee.getHoursWorked(), 0);

    }

    @Test
    public void punchOut_UserTimeTooSmall_Error() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);
        employee.punchIn(1);

        /*--------------ACT-------------*/
        employee.punchOut(-1);

        /*------------ASSERT------------*/
        assertEquals(employee.getHoursWorked(), 0);

    }

    @Test
    public void punchOut_CalledUsingDateTime_Success() {
        /*---------------ARRANGE---------------*/
        Employee employee = new Employee(1, "John Impact", "The Department", 123);

        LocalDateTime now = LocalDateTime.now();
        double hours = now.getHour();
        double minutes = now.getMinute() / 60.0;
        double timeToCheck = hours+minutes;
        employee.punchIn(timeToCheck-1);

        /*--------------ACT-------------*/
        employee.punchOut();

        /*------------ASSERT------------*/
        assertEquals(employee.clockInTime, 0);
        assertEquals(employee.getHoursWorked(), 1);

    }
}