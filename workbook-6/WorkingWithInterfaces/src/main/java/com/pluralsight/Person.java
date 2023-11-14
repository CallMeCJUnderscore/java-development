package com.pluralsight;

import java.util.*;

public class Person implements Comparable<Person>{
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



    @Override
    public int compareTo(Person p){
        return this.getLastName().compareTo(p.getLastName());
    }

    @Override
    public String toString() {
        return "com.pluralsight.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<Person>();
        myFamily.add( new Person("Dana", "Wyatt", 63) );
        myFamily.add( new Person("Zachary", "Westly", 31) );
        myFamily.add( new Person("Elisha", "Aslan", 14) );
        myFamily.add( new Person("Ian", "Auston", 16) );
        myFamily.add( new Person("Zephaniah", "Hughes", 9) );
        myFamily.add( new Person("Ezra", "Aiden", 17) );

        Collections.sort(myFamily);
        for (Person person: myFamily){
            System.out.println(person);
        }
    }
}
