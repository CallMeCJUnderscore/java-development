package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        //People created via DuckDuckGo random person generator
        people.add(new Person("Enedina", "Coryea", 18));
        people.add(new Person("Onie", "Hoeffliger", 64));
        people.add(new Person("Jettie", "Bedor", 62));
        people.add(new Person("Alejandro", "Thomeczek", 42));
        people.add(new Person("Bronwyn", "Kohus", 79));
        people.add(new Person("Candelaria", "Fortna", 82));
        people.add(new Person("Brendan", "Vanvendhuize", 85));
        people.add(new Person("Karren", "Corell", 59));
        people.add(new Person("Mickey", "Pevez", 27));
        people.add(new Person("Sharice", "Krejci", 63));

        searchForPerson(people);
        System.out.println();

        calculateAverage(people);
        System.out.println();

        findOldest(people);
        System.out.println();

        findYoungest(people);
    }
    public static void searchForPerson(ArrayList<Person> people){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> found = new ArrayList<>();
        System.out.print("Would you like to search via (F)irst name, or (L)ast name? ");
        String command = scanner.nextLine();
        System.out.print("Please type the name you would like to search for: ");
        String name = scanner.nextLine();
            for(Person person : people){
                //Ternary operator. If command is First name, return first name. if not, return last name.
                if((command.equalsIgnoreCase("F")?person.getFirstName():person.getLastName()).equalsIgnoreCase(name)){
                    found.add(person);
                }
            }
            if(found.isEmpty()){
                System.out.println("No people found!");
            }
            else{
                System.out.println("People found!");
                for(Person person :found){
                    System.out.println("First name:" + person.getFirstName());
                    System.out.println("Last name:" + person.getLastName());
                    System.out.println("Age:" + person.getAge());
                    System.out.println();
                }
            }
    }

    public static void calculateAverage (ArrayList<Person> people){
        int totalAge = 0;
        for(Person person : people){
            totalAge += person.getAge();
        }
        double averageAge = (double) totalAge / people.size();
        System.out.println("For everyone in the list, the average age is: " + averageAge);
    }

    public static void findOldest(ArrayList<Person> people){
        Person oldestPerson = people.get(0);
        for(Person person : people){
            if(person.getAge() > oldestPerson.getAge()){ oldestPerson = person;}
        }
        System.out.println("The oldest person in the list is:");
        System.out.println("First name:" + oldestPerson.getFirstName());
        System.out.println("Last name:" + oldestPerson.getLastName());
        System.out.println("Age:" + oldestPerson.getAge());
    }

    public static void findYoungest(ArrayList<Person> people){
        Person youngestPerson = people.get(0);
        for(Person person : people){
            if(person.getAge() < youngestPerson.getAge()){ youngestPerson = person;}
        }
        System.out.println("The youngest person in the list is:");
        System.out.println("First name:" + youngestPerson.getFirstName());
        System.out.println("Last name:" + youngestPerson.getLastName());
        System.out.println("Age:" + youngestPerson.getAge());
    }
}
