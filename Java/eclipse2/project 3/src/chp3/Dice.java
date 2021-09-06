package chp3;
import java.util.Random;
import java.util.Scanner;
public class Dice {
	//**********************************************************
	// Program Name: Dice.java
	//
	// Author : Wyatt Colyn
	// Date Written : Feb 1st, 2018
	// Class : Dice.java
	//
	//  Brief Description:
	//  Simulates the rolling of a pair of dice.
	//  Reviewing using the Random class
	//
	//  Challenge reviews Scanner and String classes
	//**************************************************************

	//what import statement do you need??? 


	    //-----------------------------------------------
	    // Rolls two die by generating two random numbers
	    // in the range 1 - 6.
	    //-----------------------------------------------
	    public static void main (String[] args)
	    {
			//declare 3 integer variables:  die1, die2 and totalRoll
	    	int die1;
	    	int die2;
	    	int TotalRoll;



			//create a Random object called generator
			Random generator = new Random();

			//generate a random number between 1 and 6 for die1 and die2
			die1 = generator.nextInt(6) + 1;
			die2 = generator.nextInt(6) +1;
		
			//compute totalRoll
			TotalRoll = die1 + die2;
		
			System.out.println();
			System.out.println ("You rolled " + die1 + " and " + die2 +
						" for a total of " + TotalRoll + ".");
			System.out.println();
			
			/*Output:
			 * You rolled 2 and 5 for a total of 7. 
			 */
			
	    }
	

	

	}



