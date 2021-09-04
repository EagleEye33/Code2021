/*Program Name: Seconds.java
 * Author: Wyatt Colyn
 * Date: January 31, 2018
 * Brief Description: Calculates the total seconds for given values of hours, minutes, and seconds
 * Psuedocode: The Scanner class will be used to prompt the user for the three integer values of hours, minutes, and seconds. The hours and minutes will be converted 
 * 	to seconds and then all three values will be added together under total time and the value will be displayed in total seconds. 
 */


package chp2;

import java.util.Scanner;

public class Seconds {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int hours;
		int minutes;
		int seconds;
		int totaltime;
		
		System.out.print("Enter the amount of hours: " );
				hours = scan.nextInt();
				
		System.out.print("Enter the amount of minutes: ");
				minutes = scan.nextInt();
				
		System.out.print("Enter the amount of seconds: ");
				seconds = scan.nextInt();
				
		totaltime = (hours*3600) + (minutes*60) + seconds; 	
		
		System.out.println("Total seconds: " + totaltime);
				
				
	}

}

/* Test output 1:
 Enter the amount of hours: 1
Enter the amount of minutes: 1
Enter the amount of seconds: 2
Total seconds: 3662

	Test output 2:
Enter the amount of hours: 1
Enter the amount of minutes: 45
Enter the amount of seconds: 0
Total seconds: 6300

	Test output 3:
Enter the amount of hours: 0
Enter the amount of minutes: 6
Enter the amount of seconds: 0
Total seconds: 360
*/
