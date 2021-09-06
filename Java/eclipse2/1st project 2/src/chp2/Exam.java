/*Program Name: Exam.java
	Author: Wyatt Colyn
	Date: January 31, 2018
	Brief Description: Calculates the average value for exam scores
*/

package chp2;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int exam1;
		int exam2; 
		int exam3;
		double average;
		double numberofexams;
		
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		System.out.print("enter first exam score here: ");
			exam1 = scanner.nextInt();
			
		System.out.print("enter second exam score here: ");	
			exam2 = scanner.nextInt();
			
		System.out.print("enter third exam score here: ");
			exam3 = scanner.nextInt();
		
		System.out.print("enter the number of exams here: ");
			numberofexams = scanner.nextInt();
			
			average = (exam1 + exam2 + exam3)/numberofexams;
			
			System.out.println("The average exam score for " + exam1 + ", " + exam2 + ", and " + exam3 + " is " + average);
			
		/* Output:
		 * enter first exam score here: 90
			enter second exam score here: 91
			enter third exam score here: 100
			enter the number of exams here: 3
			The average exam score for 90, 91, and 100 is 93.66666666666667
			*/
	}

}
