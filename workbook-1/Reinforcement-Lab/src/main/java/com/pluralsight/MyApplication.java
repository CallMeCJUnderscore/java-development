package com.pluralsight;
import java.util.Scanner;

public class MyApplication {
    static Scanner scanner = new Scanner(System.in);
    static double num1;
    static double num2;
    public static String promptName(){
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        //Format name. Tom vs JP
        if (name.length()>=3) {name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();}
        else {name = name.toUpperCase();}
        return name;
    }

    public static int promptAge(){
        System.out.print("Please enter your age: ");
        return scanner.nextInt();
    }

    public static void promptNumbers(){
        System.out.print("Please enter a number: ");
        num1 = scanner.nextDouble();
        System.out.print("Please enter another number: ");
        num2 = scanner.nextDouble();
    }

    public static void welcome(String name, int age){
        System.out.printf("Hello, %s! Currently, you are %d years old.\nAlso, ", name, age);
        logic(name,age);
    }

    public static void logic(String name, int age){
        System.out.println((age >= 18)? //Step 4
                "you are old enough to vote!"
                :"you are not old enough to vote.");

        switch(name){ //Step 10
            case "Alice":
                System.out.println("Welcome back, Administrator!");
                break;
            case "Bob":
                System.out.println("Hey there, Bob! Wanna grab a drink sometime?");
            default:
                System.out.println("Welcome, guest user!");
        };
    }

    public static double findSquareRoot(double num){
        double root = Math.sqrt(num);
        System.out.printf("The square root of %f is %f.\n", num, root);
        return root;
    }

    public static boolean isGreater(){
        boolean isGreater = num1 > num2;
        return isGreater;
    }

    public static double findLarger(){
        System.out.println("Let's find a larger number.");
        promptNumbers();
        double larger = Math.max(num1, num2);
        return larger;
    }

    public static double findSmaller(){
        System.out.println("Let's find a smaller number.");
        promptNumbers();
        double smaller = Math.min(num1, num2);
        return smaller;
    }

    public static double createRandom(){
        double random = Math.random();
        return random;
    }

    public static void main(String[] args) {
        String name;
        int age;
        double larger;
        double smaller;
        double random;

        name = promptName(); //Step 3
        age = promptAge();
        welcome(name,age);

        System.out.print("\nPlease input a number: "); //Step 9
        num1 = findSquareRoot(scanner.nextDouble());

        System.out.println("Let's check if num1 is larger than num2.");
        promptNumbers();
        System.out.println("Is num1 larger than num2: " + isGreater() + "."); //Step 11

        //Step 12
        System.out.println(name.equals("Eve")? "You're not welcome here. Please leave." : "Ah, you're not Her. You are certainly welcome here.");

        larger = findLarger(); //Step 13
        System.out.printf("\nOf the two numbers given, %f is the larger of the two.", larger);

        random = createRandom(); //Step 14
        System.out.printf("\nHere's a random number between 0 and 1: %f.", random);

        smaller = findSmaller(); //Step 15
        System.out.printf("\nOf the two numbers given, %f is the smaller of the two.", smaller);
    }
}
