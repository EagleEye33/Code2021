/*Program Name: ChangeMaker.java
 * Author: Wyatt Colyn
 * Date: February 4, 2018
 * Brief Description: Calculates the smallest amount of change in cents.
 * PsuedoCode:  A number between 1 and 99 will be prompted for the user using the scanner class. The number value given will be divided by 3 for the amount 
 * of quarters and the remainder will be found. This remainder will be divided by 10 for the number of dimes and then a new remainder value will be calculated.
 * This new remainder value will be divided by five for the amount of nickels, and then the last remainder value will be set equal to the amount of pennies.
 * 
 */

package chp2;

import java.util.Scanner;

public class ChangeMaker {

	public static void main(String[] args) {
		
		System.out.println( "Welcome to ChangeMaker.\n" + 
				"I will find a combination of coins\n" + 
				"that equals that amount of change you should receive.\n");
		
		Scanner scan = new Scanner(System.in);
		
		int totalCents;
		
		System.out.print("Please enter an amount from 1 to 99: ");
		totalCents = scan.nextInt();
		
		int numberofquarters = totalCents/25;
		int remainingcents1 = totalCents%25;
		int numberofdimes = remainingcents1/10;
		int remainingcents2 = remainingcents1%10; 
		int numberofnickels = remainingcents2/5;
		int remainingcents3 = remainingcents2%5;
		int numberofpennies = remainingcents3;
		
		System.out.println(totalCents + " cents in coins can be given as:\n" +
				numberofquarters + " quarters\n" +
				numberofdimes + " dimes\n" +
				numberofnickels + " nickels and\n" +
				numberofpennies + " pennies\n");
		
		/* Test Output Case 1:
		 * Welcome to ChangeMaker.
		I will find a combination of coins
		that equals that amount of change you should receive.

		Please enter an amount from 1 to 99: 88
		88 cents in coins can be given as:
		3 quarters
		1 dimes
		0 nickels and
		3 pennies
		
		Test Output Case 2:
		Welcome to ChangeMaker.
		I will find a combination of coins
		that equals that amount of change you should receive.

		Please enter an amount from 1 to 99: 51
		51 cents in coins can be given as:
		2 quarters
		0 dimes
		0 nickels and
		1 pennies
		
		Test Output Case 3:
		Welcome to ChangeMaker.
		I will find a combination of coins
		that equals that amount of change you should receive.

		Please enter an amount from 1 to 99: 17
		17 cents in coins can be given as:
		0 quarters
		1 dimes
		1 nickels and
		2 pennies
		
		Test Output Case 4:
		Welcome to ChangeMaker.
		I will find a combination of coins
		that equals that amount of change you should receive.

		Please enter an amount from 1 to 99: 4
		4 cents in coins can be given as:
		0 quarters
		0 dimes
		0 nickels and
		4 pennies	 */
	}

}
