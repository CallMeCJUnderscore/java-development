package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Set up initial variables
        ArrayList<Hand> hands = new ArrayList<>();
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);
        deck.shuffle();

        //Set game size
        System.out.println("Let's play some Blackjack!");
        System.out.print("How many people are going to play this hand? ");
        int playerCount = scanner.nextInt();
        scanner.nextLine(); //Eat newline character

        //Set up players
        for(int i = 0; i<playerCount; i++){
            hands.add(new Hand());
        }
        int[] scores = new int[hands.size()];
        for(int i = 0; i<2; i++){
            for(Hand hand: hands){
                hand.Deal(deck.deal());
            }
        }

        //Core gameplay loop
        for(int i=0; i<hands.size();i++){
            int player = i+1;
            boolean playing=true; //Set up loop for a given player
            do {
                scores[i] = hands.get(i).getValue();
                System.out.print("\nPlayer " + player + " has the following "); //Display hand
                hands.get(i).Print();
                if (scores[i] > 21) { //Check for bust
                    scores[i] = -1;
                    System.out.println("Player " + player + " has busted!");
                    playing=false;
                } else {
                    System.out.println("Player " + player + " has a score of: " + scores[i]);
                    System.out.print("Would you like to (H)it, or (S)tay? "); //Prompt user for action
                    char action = scanner.nextLine().trim().toUpperCase().charAt(0);
                    if (action != 'H'){playing = false;}
                    else{hands.get(i).Deal(deck.deal());}
                }
            }while(playing);
        }

        //Determine winner
        int highScore = 0;
        int winner = 0;
        for(int i=0;i<scores.length;i++){
            if(scores[i]>highScore){
                highScore=scores[i];
                winner=i+1;
            }
            else if(scores[i]==highScore){
                winner = -1;
            }
        }

        System.out.print("\n\n");
        if(winner == -1){
            System.out.println("The game is a tie!");
        }
        else{
            System.out.println("Player "+winner+" wins the hand!");
        }

/*        System.out.println();

        if(p1Score>p2Score){
            System.out.println("Player 1 wins the hand!");
        }
        else if(p2Score>p1Score){
            System.out.println("Player 2 wins the hand!");
        }
        else{
            System.out.println("The hand is a tie!");
        }*/


    }
}
