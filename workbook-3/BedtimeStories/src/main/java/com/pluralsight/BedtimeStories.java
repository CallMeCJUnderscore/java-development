package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class BedtimeStories {


    public static void main(String[] args) {
        FileInputStream fis; //create necessary variables
        Scanner scanner = new Scanner(System.in);
        String input;
        String storyPath = "";

        System.out.println("Your story options are:"); //prompt user
        System.out.println("    (G)oldilocks");
        System.out.println("    (H)ansel & Gretel");
        System.out.println("    (M)ary Had a Little Lamb");
        System.out.print("Please pick the one you would like to have read: ");
        input = scanner.nextLine().toUpperCase();

        switch (input){ //check user choice
            case "G":
                storyPath = "goldilocks.txt";
                break;
            case "H":
                storyPath = "hansel_and_gretel.txt";
                break;
            case "M":
                storyPath = "mary_had_a_little_lamb.txt";
                break;
        }
        try{ //attempt to display chosen story
            fis = new FileInputStream(storyPath);
            scanner.close(); //change input source for scanner object
            scanner = new Scanner(fis);
            while (scanner.hasNextLine()){
                input=scanner.nextLine();
                System.out.println(input);
            }
        }
        catch (Exception e){ //throw error if story cannot be read
            System.out.println("ERROR: Story could not be initialized");
        }
    }
}
