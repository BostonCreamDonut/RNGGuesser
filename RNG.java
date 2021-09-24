import java.util.Random;
import java.util.Scanner;

/**
 * This is the utility class to accompany RandomNumberGuesser
 * It contains static methods to generate a random number,
 * validate the guesses as being between the previous low and high guesses,
 * and maintain the number of guesses.
 * @author ralexander
 */
public class RNG {
	private static int count=0;
	static Scanner scan;
	public RNG() {
		count++;
	}
	
	/**
	 * Sets the count to zero
	 */
	public static void resetCount() {
		count = 0;
	}
	
	/**
	 * generates a random integer between 1 and 100
	 * @return the random number as an integer
	 */
	public static int rand() {
		Random rand = new Random();
		int randInt = rand.nextInt(100)+1;
		return randInt;
	}
	
	/**
	 * Checks that nextGuess is strictly between lowGuess and highGuess
	 * @param nextGuess
	 * @param lowGuess
	 * @param highGuess
	 * @return a boolean, true if the guess is with the bounds, false otherwise
	 */
	public static boolean inputValidation(int nextGuess, int lowGuess, int highGuess) {
		//do {
		boolean rtnValue = true;
		if (nextGuess>=highGuess || nextGuess<=lowGuess) {
				   System.out.println("   >>> Guess must be between "+lowGuess+" and "+highGuess+
						   ".  Try again");				   
				   rtnValue = false;
			   }
		//	} while (nextGuess>=highGuess || nextGuess<=lowGuess);
		count++;
		return rtnValue;
		
	}

	/**
	 * @return an integer, the current value of count
	 */
	public static int getCount() {
		return count;
	}
}
