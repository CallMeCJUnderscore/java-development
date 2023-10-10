package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        String score = "";
        Scanner scanner = new Scanner(System.in);
        String winner;

        System.out.print("Please enter a score:");
        score = scanner.nextLine();
        String[] parts = score.split("[:|]");
        if (parts.length !=4){
            System.out.println("Error: Invalid Score format");
        }


        int score1 = Integer.parseInt(parts[2]);
        int score2 = Integer.parseInt(parts[3]);
        if(score1 > score2){winner = parts[0];}
        else if(score2 > score1){winner = parts[1];}
        else {winner = "Tie";}

        System.out.println("Winner: " + winner);
    }
}
