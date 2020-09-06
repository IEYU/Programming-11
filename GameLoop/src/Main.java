//import the Scanner class
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int wins = 0;
        int losses = 0;

        //print the instruction for the player
        System.out.println("Choose rock paper or scissors. 'r' for rock, 'p' for paper and 's' for scissors. To exit choose 'x'");

        while (true) {
            //first displays wins and losses when the new game starts
            System.out.println("Wins: " + wins + "\t" + "Losses: " + losses);


            //create a scanner object
            Scanner player_object = new Scanner(System.in);
            System.out.println("Players Choice:");
            //store the player's choice in the variable player_choice based on the user input
            String player_choice = player_object.next();


            //the player inputs the exit command and the game ends
            if (player_choice.equals("x")){
                System.out.println("Thank you for playing!");
                break;
            }

            //otherwise, the game continues
            //r represents rock, p represents paper, and s represents scissors
            else if (player_choice.equals("r")) {
                player_choice = "rock";
            }
            else if (player_choice.equals("p")) {
                player_choice = "paper";
            }
            else if (player_choice.equals("s")) {
                player_choice = "scissors";
            }
            //if the user input is invalid (not r, p or s)
            else {
                System.out.println("Invalid selection. Please play again.");
                System.out.println("*********************************************");
                continue;
            }


            //create a variable computer_choice to store the computer's choice string
            String computer_choice;
            //randomly generalize the computer's choice (a random integer on the interval [0, 3))
            int computer_random = (int)(Math.random()*3);


            //translate the randomly generalized number into the corresponding computer's choice of rock, paper or scissors
            //0 represents rock, 1 represents paper, and 2 represents scissors
            if (computer_random == 0){
                computer_choice = "rock";
            }
            else if (computer_random == 1){
                computer_choice = "paper";
            }
            else {
                computer_choice = "scissors";
            }


            //the winning rule: rock > scissors, scissors > paper, paper > rock
            //if the player and the computer have the same choice, a draw occurs, and nobody gains a point
            if (player_choice.equals(computer_choice)){
                System.out.println("Draw!");
            }
            //if not a draw
            else{
                //when the computer'choice is rock, if the player has paper, the player wins and wins increases by 1, else, the player loses and losses increase by 1.
                if(computer_choice.equals("rock")){
                    if(player_choice.equals("paper")){
                        wins ++;
                        System.out.println("You Win!");
                    }
                    else{
                        losses ++;
                        System.out.println("You Lose!");
                    }
                }
                //when the computer's choice is paper, if the player has rock, the player loses and losses increase by 1, else, the player wins and wins increases by 1.
                else if(computer_choice.equals("paper")){
                    if(player_choice.equals("rock")){
                        losses ++;
                        System.out.println("You Lose!");
                    }
                    else{
                        wins ++;
                        System.out.println("You Win!");
                    }
                }
                //when the computer's choice is scissors, if the player has rock, the player wins and wins increases by 1, else, the player loses and losses increase by 1.
                else{
                    if(player_choice.equals("rock")){
                        wins ++;
                        System.out.println("You Win!");
                    }
                    else{
                        losses ++;
                        System.out.println("You Lose!");
                    }
                }
            }


            //prints the computer's choice and the player's choice respectively
            System.out.println("Computer Choice: " + computer_choice + "\t" + "Player Choice: " + player_choice);
            System.out.println("*********************************************");
        }
    }
}
