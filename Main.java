//import java.io.*;
//import java.nio.file.*;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
public static void main(String[] args) {
    //Declare variables
    Scanner input = new Scanner(System.in);
    String cmd = "";
    Integer win = 0;
    Integer lose = 0;
    Integer round = 0;
    String P1 = "";


    //Menu Screen Selections
    while(!cmd.toLowerCase().equals("exit")) {
        displayMenu();
        cmd = input.nextLine(); // Get user input
        if(cmd.toLowerCase().equals("rules")) {
            displayRules(); }
        else if(cmd.toLowerCase().equals("play")) {
            gameRounds(0);
        }
    }
}
//Menu Display
public static void displayMenu() {
    System.out.println("\n\nRock, Paper, Scissors");
    System.out.println("---------------------");
    System.out.println("\nRules - Display Game Rules");
    System.out.println("Play - Start Game");
    System.out.println("Exit - End Game");
    System.out.print("Enter a Command: ");
}

    //Rules
public static void displayRules() {
    System.out.println("\nRules:");
    System.out.println("You are playing Rock, Paper, Scissors against the computer.");
    System.out.println("The game is played by choosing one of the three options:");
    System.out.println("\tRock, Paper, or Scissors.");
    System.out.println("The game will also choose one of the three options.");
    System.out.println("The winner is determined based on the following:");
    System.out.println("\tRock beats Scissors");
    System.out.println("\tScissors beats Paper");
    System.out.println("\tPaper beats Rock\n");
    System.out.println("If both players choose the same option, the game is tied and you play again.");
    System.out.println("Choose to play from 1 round up to 10 rounds.");
    System.out.println("Good Luck!\n\n");
}


    //Decide how many rounds to play
    public static void gameRounds(int round) { 
        Scanner input = new Scanner(System.in); 

        do { 
            System.out.println("\nHow many rounds would you like to play?"); 
            System.out.println("Pick a number between 1 & 10"); 
            while (!input.hasNextInt()) { 
                System.out.println("Enter a valid number."); 
                input.next(); // Clear the invalid input
            } 
            round = input.nextInt(); 
            if (round < 1 || round > 10) { 
                System.out.println("Enter the number of rounds to play between 1 & 10."); //Enforce a range of numbers between 1 and 10
            } 
        } while (round < 1 || round > 10); 
        System.out.println("Let's play " + round + " rounds.\n");
        playGame(round,"",0,0);
    }
//Play Game
public static void playGame(int round, String P1, int win, int lose) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    do {
        System.out.println("\n\nPick Rock, Paper, or Scissors?\n");
        while (!input.hasNextLine()) {
            System.out.println("Enter a valid choice: rock, paper, or scissors.\n");
            input.next(); // Clear the invalid input
        }
        P1 = input.nextLine().toLowerCase();
        if (!(P1.equals("rock") || P1.equals("paper") || P1.equals("scissors"))) {
            System.out.println("Not a valid choice."); //Enforce a valid choice
        }
    } while (!(P1.equals("rock") || P1.equals("paper") || P1.equals("scissors")));

    System.out.println("You chose " + P1 + ".");
    int rand = random.nextInt(3) + 1; // Generates a number between 1 and 3 to represent rock, paper, or scissors

//Let player know what player 2 chose
    if (rand == 1) {
        System.out.println("Player 2 chose rock.");
    }
    else if (rand == 2) {
        System.out.println("Player 2 chose paper.");
    }
    else if (rand == 3) {
        System.out.println("Player 2 chose scissors.");
    }

    //Update score
    if (
        (P1.equals("rock") && rand == 1) ||
        (P1.equals("paper") && rand == 2) ||
        (P1.equals("scissors") && rand == 3)
    ) {
        System.out.println("It's a tie!");} //Tie condition

    else if (
        (P1.equals("rock") && rand == 2) ||
        (P1.equals("paper") && rand == 3) ||
        (P1.equals("scissors") && rand == 1) //Lose round condition
    ) { 
        lose += 1;
        System.out.println("You lose this round.");}
    else if (
        (P1.equals("rock") && rand == 3) ||
        (P1.equals("paper") && rand == 1) ||
        (P1.equals("scissors") && rand == 2) //Win round condition
    ) {
        win += 1;
        System.out.println("You win this round.");}
    else {
        System.out.println("Error!");
    }

    round -= 1;
    System.out.println("\nScore: P1 has " + win + " wins. P2 has " + lose + " wins."); //Let player know score
    System.out.println("Rounds left: " + round); //Let player know rounds left
    checkWinner(win,lose,round);
}

    //Check rounds to see if game is over and declare winner
    public static void checkWinner(int win, int lose, int round) {
        if (round != 0) {
            playGame(round,"",win,lose); //Keep playing if the rounds aren't finished
        }
        else if (round == 0 && win == lose) {
            System.out.println("Tie breaker!"); //Play another round if it's a tie
            round += 1;
            playGame(round,"",win,lose);
        }
        else if (round == 0 && win > lose) {
            System.out.println("\n" + win + " vs. " + lose);
            System.out.println("You won the game!!!"); //Declare the player as the winner
        }
        else if (round == 0 && lose > win)
        { 
            System.out.println("\n" + win + " vs. " + lose);
            System.out.println("You lost the game!!! :("); //Declare player as the loser
        }
        else {
            System.out.println("Error!");
        }

    }
}

