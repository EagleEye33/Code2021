/*Program Name: PhoneNumber.java
 * Author: Wyatt Colyn
 * Date: February 4, 2018
 * Brief Description: Generates a random phone number. 
 * Pseudocode: The first three digits must be broken up and set to a int(8) to accommodate for the restriction "the first three digits cannot be an 8 or 9."
 * The second three digits will be set to int(743) to accommodate the second restriction (digits between 0-742). The last four digits to be set to int(10000)
 * to output a value 0-9999. Two decimalformat classes will be used to format the second and third set of digits.
 */

package chp3;

import java.text.DecimalFormat;
import java.util.Random;

public class PhoneNumber {

	public static void main(String[] args) {
		
		int num1, num2, num3, num4, num5;
		
		Random generator = new Random();
		
		num1 = generator.nextInt(8);
		num2 = generator.nextInt(8);
		num3 = generator.nextInt(8);
		num4 = generator.nextInt(743);
		num5 = generator.nextInt(10000);
		
		DecimalFormat dFmt = new DecimalFormat("000");
		DecimalFormat dfmt = new DecimalFormat("0000");
		
		System.out.println("My new phone number is: " + num1+num2+num3 + "-" +dFmt.format(num4) + "-" +dfmt.format(num5));
		
		/*Some test output:
		 * My new phone number is: 720-369-1516
		 * My new phone number is: 611-595-3742
		 * My new phone number is: 010-447-2690
		 * My new phone number is: 770-652-8356
		 * My new phone number is: 403-388-6999
		 */
	}

}
