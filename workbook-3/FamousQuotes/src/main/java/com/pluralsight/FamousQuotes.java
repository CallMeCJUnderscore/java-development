package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        //Declare variables
        String[] quotes = {"\"I am a monument to all your sins.\"\n -Gravemind, Halo 2",
                "\"One day, you will be face to face with whatever saw fit to let you exist in the universe, and you will have to justify the space you’ve filled.\"\n -curseworm, Tumblr",
                "\"I survived because the fire inside me burned brighter than the fire around me.\"\n -Joshua Graham, Fallout: New Vegas",
                "\"I will face God and walk backwards into hell.\"\n - @dril, Twitter",
                "\"Stand in the ashes of a thousand dead souls and ask the ghosts if honor matters. Their silence is your answer.\"\n -Javik, Mass Effect",
                "\"God may judge you, but his sins outnumber your own.\"\n -afabbaeddel, Tumblr",
                "\"The man who sleeps with a machete is a fool every night but one.\"\n -Justin McElroy, MBMBAM (Episode 137: Tangentz)",
                "\"The penance you pay for the way you behave is written as plain as the name on this grave.\"\n -Death, Epic Rap Battles Of History (Ebenezer Scrooge vs. Donald Trump)",
                "\"Kill me and live with the memory. Then tell the stars that you’ve won.\"\n -Grey Wing, Warriors: The First Battle",
                "\"Authority should derive from the consent of the governed, not from the threat of force.\"\n -Barbie, Toy Story 3"};
        String input;
        Random random = new Random();
        int max = quotes.length - 1;
        int min = 0;
        Scanner scanner = new Scanner(System.in);
        int index;

        while(true){//run infinitely until prompted by user
            System.out.print("\nWelcome, please type a number between 1 and 10 to get the corresponding quote, or R to get a random one: ");
            input = scanner.nextLine();

            if(input.equalsIgnoreCase("R")){ //check if user wants random quote
                index = random.nextInt((max - min) + 1) + min;
                System.out.println(quotes[index]);
            }
            else { //see if they input a valid index, and throw an error if they don't
                try {
                    index = Integer.parseInt(input) - 1;
                    System.out.println(quotes[index]);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid option selected");
                }
            }
            System.out.print("\nWould you like to select another quote (Y/N)? "); //prompt for repeat
            input=scanner.nextLine();
            if(!input.equalsIgnoreCase("Y")){return;}
        }
    }
}
