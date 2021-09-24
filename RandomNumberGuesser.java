/*
Class: CMSC203 CRN 24307
Program: Assignment #2
Instructor: Professor Tsai
Summary of Description: Write a program that picks a number between 0-100, and the user
is prompted to try and guess the number. the range changes based on what the user inputs;
if the random number was 50, and the user input 80, the new range would be 0-79 (tells user if higher or lower).
Due Date: 09/26/2021 
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Michael DeReggi
*/
import java.util.Scanner;
public class RandomNumberGuesser
{
	//runner for RNG guess program
	public static void main(String[] args)
	{
		String another="y";
		while(another.equals("y"))
		{
			//initiate variables
			int rangeI=0;
			int rangeF=100;
			boolean first=false;
			boolean second=false;
			//get random number for guesser
			int random=RNG.rand();
			//create scanner
			Scanner input=new Scanner(System.in);
			//only for first guess
			System.out.println("Enter your first guess");
			int guess=input.nextInt();
			while(first==false)
			{
				//adds to count and checks val for FIRST input
				if(RNG.inputValidation(guess,rangeI,rangeF))
				{
					first=true;
				}
				else
				{
					guess=input.nextInt();
				}
			}
			//checks if first guess is high, low, or right
			if(guess>random)
			{
				System.out.println("Your guess is too high");
				rangeF=guess;
			}
			else if(guess<random)
			{
				System.out.println("Your guess is too low");
				rangeI=guess;
			}
			//this repeats process for guess until right
			while(guess!=random)
			{
				System.out.println("Enter your guess between "+rangeI+" and "+rangeF);
				guess=input.nextInt();
				while(second==false)
				{
					//adds to count and checks val for rest of inputs
					if(RNG.inputValidation(guess,rangeI,rangeF))
					{
						second=true;
					}
					else
					{
						guess=input.nextInt();
					}
				}
				//checks if guess is high, low, or equal
				if(guess>random)
				{
					System.out.println("Your guess is too high");
					rangeF=guess;
				}
				else if(guess<random)
				{
					System.out.println("Your guess is too low");
					rangeI=guess;
				}
				second=false;
			}
			//displays when loop ends, loop only ends when guess is right
			System.out.println("Congratioulations, you guessed correctly");
			//display full count
			System.out.println("guesses:"+RNG.getCount());
			//resets count in case user wants to go again
			RNG.resetCount();
			//ask user if they want to go again
			System.out.println("Try again?( y or n)");
			input.nextLine();
			another=input.nextLine();
			//if user does not enter y or n, repeats until input y or n
			while(!(another.equals("y")||another.equals("n")))
			{
				System.out.println("You did not enter y or n.");
				System.out.println("Try again?( y or n)");
				another=input.nextLine();
			}
			
		}
		System.out.println("Thanks for playing...\n\nMichaelDeReggi");
	}
}
