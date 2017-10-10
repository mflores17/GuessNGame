//Marcos Flores
//Java 112

import java.util.Scanner;

public class GuessNGame
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		int userNum; //using this for all numbers the player will input
		int randNum; //using this for all numbers the computer player will choose
		int maxRand; //used once. The user inputs the range of numbers
		double numGuesses = 0, i; //need to use double since we deal with division for the final results
		double correctGuesses = 0, j; 
		String userChoice = "y"; //use y instead of null for userChoice so that the program starts. Later on it can be either y or n. Anything else terminates the game
		
		System.out.print("Choose difficulty. Select the upper limit of the range of numbers the computer can pick: ");
		maxRand = Integer.parseInt(input.nextLine()); //use Integer.parseInt(input.nextLine() instead of the regular input.nextInt() so I don't deal with the hanging newline
		
		randNum = 1 + (int) ( Math.random() * maxRand); //during testing I included a System.out.println(randNum) line after this one so I could win the game at any time (to test results)

		System.out.print("Computer guessed a number from 1 to "+ maxRand +". Input your guess: ");
		userNum = Integer.parseInt(input.nextLine()); //see line 20
		
		if (userNum  <= 0 || userNum >= maxRand +1) //confines the player guesses to within the range chosen in the beginning
		{
			System.out.println("Not a number between 1 and " + maxRand + ".");
			System.out.println("Game terminated. Please follow instructions.");
		}
		else 
		{
			do //the do{} while() was necessary to loop the game under the while conditions
			{
				if (userChoice.equals("y"))
				{
					if (userNum < randNum)
					{
						System.out.println("Incorrect. Your guess was too low.");

						System.out.print("Would you like to play again? Type y for yes and n for no: ");
						userChoice = input.nextLine();
						
						if (userChoice.equals("y"))
						{
							System.out.print("Guess again: ");
							userNum = Integer.parseInt(input.nextLine()); //see line 20
						}
					}
					else if (userNum > randNum)
					{
						System.out.println("Incorrect. Your guess was too high.");

						System.out.print("Would you like to play again? Type y for yes and n for no: ");
						userChoice = input.nextLine();
						
						if (userChoice.equals("y"))
						{
							System.out.print("Guess again: ");
							userNum = Integer.parseInt(input.nextLine()); //see line 20
						}
					}
					else
					{
						System.out.println("Correct. You win.");
						j=++correctGuesses; //anytime userNum==randNum variable correctGuesses will be increased by one
						System.out.print("Would you like to play again? Type y for yes and n for no: ");
						userChoice = input.nextLine();
						
						if (userChoice.equals("y"))
						{
							randNum = 1 + (int) ( Math.random() * maxRand);
							System.out.println(randNum);
							System.out.print("Computer guessed a new number from 1 to "+ maxRand +". Input your guess: ");
							userNum = Integer.parseInt(input.nextLine()); //see line 20
						}
					}
					
				}
				if (userChoice.equals("n"))
					System.out.println("Goodbye.");
				if (!userChoice.equals("y") && !userChoice.equals("n")) //if at any point during the game any option other than y or n is chosen for continuing to play the game will terminate. Results are still printed, unlike with lines 27-31
				{
					System.out.println("Command not recognized. Game terminated. Please follow instructions.");
					userChoice.equals("n"); //in order to print out the results, the computer chooses n as the player input to the option to keep playing
				}
				i=++numGuesses; //after every loop, the number of guesses (numGuesses) is increased by one
			} while (userChoice.equals("y")); //the while condition of the do{} while() loop. As long as the player wants to keep playing (selecting y) the game will loop
			System.out.println("Results:\nTotal number of guesses: "+numGuesses); //prints total guesses
			System.out.println("Percentage of correct guesses: " + correctGuesses/numGuesses*100 +"%"); //this line is the reason double is used instead of int
			System.out.println("Number of good guesses: "+correctGuesses); //prints correct guesses
			System.out.println("Number of bad guesses: "+ (numGuesses-correctGuesses)); //prints incorrect guesses
		}
	}
}

//Good job, Marcos
