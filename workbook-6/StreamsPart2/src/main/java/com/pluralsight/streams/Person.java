package com.pluralsight.streams;

import java.util.Comparator;

public class Person {
    /*---------------VARIABLES---------------*/

    private String firstName;
    private String lastName;
    private int age;

    /*--------------CONSTRUCTORS-------------*/

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /*------------GETTERS/SETTERS------------*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*---------------FUNCTIONS---------------*/

    public static Comparator<Person> sortAge(){
        return Comparator.comparing(Person::getAge);
    }

}
