//Written By Yoshitha Chilukuri

import java.util.Scanner;
import java.util.Random;
public class Homework03 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();


		boolean breakLoop = false;
		while (!breakLoop){
			int userPoints = 0;
			int compPoints = 0;
			int drawScore = 0;
			int roundNum = 0;
			System.out.println("Would you like to play rock, paper, scissors (yes/no)?");
			String playDecision = keyboard.nextLine();
			if (playDecision.equalsIgnoreCase("yes")) {

				// Rock-Paper-Scissors game start
				System.out.println("Welcome to 'Rock Paper Scissors'!\nYou will be up aganist the computer! (Best 2 out of 3)");
				//while(userScore < 2 || compScore < 2) {
				for (roundNum = 1; roundNum <= 3; roundNum++){
					System.out.println("Please select your choice --> (Rock/Paper/Scissors)");
					String playerChoice = keyboard.nextLine();


					// get random number between 1 and 3
					int randomNumber = rand.nextInt(3) + 1;
					String computerChoice;
					// Set computer choice based randomNumber value
					if (randomNumber == 1) {
						computerChoice = "Rock";
					} else if (randomNumber == 2) {
						computerChoice = "Paper";
					} else {
						computerChoice = "Scissors";
					}


					if (playerChoice.equalsIgnoreCase("Rock") || playerChoice.equalsIgnoreCase("Paper")
							|| playerChoice.equalsIgnoreCase("Scissors")) {

						// all three draw combinations handled here
						if (playerChoice.equalsIgnoreCase(computerChoice)) {
							System.out.println("Computer chose " + computerChoice + "!");
							System.out.println("It's a draw! No points awarded to anyone.");
							drawScore++;
						}
						// all three player winning combinations handled here
						else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors"))
								|| (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock"))
								|| (playerChoice.equalsIgnoreCase("Scissors")
										&& computerChoice.equalsIgnoreCase("Paper"))) {
							System.out.println("Computer chose " + computerChoice);
							System.out.println(playerChoice + " beats " + computerChoice + ", you won 1 point!");
							userPoints++;
						}
						// all three player loosing combinations handled here
						else {
							System.out.println("Computer chose " + computerChoice);
							System.out.println(computerChoice + " beats " + playerChoice + ", computer won 1 point!");
							compPoints++;
						}
					} else {
						System.out.println("Not valid input! Computer won a point!");
						compPoints ++;
					}

				}
				//evaluating scores to determine who won    start
				System.out.println("\n**********************************************");
				if (userPoints > compPoints) {
					System.out.println("***         You won!                       ***");
				}
				else if (userPoints < compPoints) {
					System.out.println("***         Computer won!                  ***");
				}
				else {
					System.out.println("***         It's a draw!                   ***");
				}
				System.out.println("***         Your points: " + userPoints + "                 ***");
				System.out.println("***         Computer points: " + compPoints + "             ***");

				//number of times draw occurred within the game; all scores reset after game ends
				System.out.println("***         # of Draws: " + drawScore + "                  ***"); 
				System.out.println("**********************************************\n");
				//evaluating scores to determine who won    end
			}
			//this statement executes if user enters no to continue the game; loop will break after this
			else {
				System.out.println("Exiting program now..");
				breakLoop = true;
			}
		}
		keyboard.close();
	}
}
