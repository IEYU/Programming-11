//import the Scanner class
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //create a scanner object
        Scanner player_object = new Scanner(System.in);

        //prints the instruction for the player
        System.out.println("Choose rock, paper, or scissors. 'r' for rock, 'p' for paper, 's' for scissors.");

        //store the player's choice in the variable player_choice based on the user input
        String player_choice = player_object.next();

        //r represents rock
        if(player_choice.equals("r")){
            player_choice = "rock";
        }
        //p represents paper
        else if(player_choice.equals("p")){
            player_choice = "paper";
        }
        //s represents scissors
        else if(player_choice.equals("s")){
            player_choice = "scissors";
        }

        //if the user input is invalid (not r, p, or s), return
        else{
            System.out.println("Invalid selection. Please play again.");
            return;
        }

        //create a variable computer_choice to store the computer's choice string
        String computer_choice;

        //randomly generalize the computer's choice (a random integer on the interval [0, 3))
        int computer_random = (int)(Math.random()*3);

        //translate the randomly generalized number into the corresponding computer's choice of rock, paper, or scissors
        //0 represents rock
        if (computer_random == 0){
            computer_choice = "rock";
        }
        //1 represents paper
        else if(computer_random == 1){
            computer_choice = "paper";
        }
        //2 represents scissors
        else{
            computer_choice = "scissors";
        }

        //the winning rule: rock > scissors, scissors > paper, paper > rock
        //if the player and the computer have the same choice, a draw occurs
        if (player_choice.equals(computer_choice)){
            System.out.println("Draw!");
        }
        //if not draw
        else{
            //when the computer'choice is rock, if the player has paper, the player wins, else, the player loses
            if(computer_choice.equals("rock")){
                if(player_choice.equals("paper")){
                    System.out.println("You Win!");
                }
                else{
                    System.out.println("You Lose!");
                }
            }
            //when the computer's choice is paper, if the player has rock, the player loses, else, the player wins
            else if(computer_choice.equals("paper")){
                if(player_choice.equals("rock")){
                    System.out.println("You Lose!");
                }
                else{
                    System.out.println("You Win!");
                }
            }
            //when the computer's choice is scissors, if the player has rock, the player wins, else, the player wins
            else{
                if(player_choice.equals("rock")){
                    System.out.println("You Win!");
                }
                else{
                    System.out.println("You Lose!");
                }
            }
        }

        //prints the computer's choice and the player's choice respectively
        System.out.println("Computer Choice: " + computer_choice + "\t" + "Player Choice: " + player_choice);
    }
}
