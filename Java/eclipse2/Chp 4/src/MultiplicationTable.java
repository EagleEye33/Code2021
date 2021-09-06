/*
Program Name :  MultiplicationTable.java
Author : Wyatt Colyn
Date : March 5, 2018
Class: CSC110AA/AB and CIS163AA
Description:
		  This program prompts the user for a number 1 - 5, 
		  checks for bad input,
		  and creates a multiplication table.
		  Student completes.
*/

import java.util.Scanner;

/* produces a multiplication table of integers */

public class MultiplicationTable {
	public static void main(String[] args) 
	{
		int size;
		Scanner scan = new Scanner (System.in);

			
		//read in size of multiplication table
		System.out.print("Please enter the table size from 1 to 5 (0 to quit): ");
		size = scan.nextInt();

		while (size > 5 || size < 0) {
			System.out.println("Sorry, not a valid table size from 1 to 5. Try again.");
			System.out.print("Please enter the table size from 1 to 5 (0 to quit): ");
			size = scan.nextInt();
				
		//using a for loop, display the top header row of numbers

		}
		
		//using a for loop, display the top header row underline (use a dash)
		System.out.print("\t");
		for (int horiz = 1; horiz <= size; horiz++)
		{    System.out.print("-" + "\t");		}
			
		System.out.println();
		
				
		/* using a nested for loop create the rest of the table */
		
			while (size !=0) {
				
		if (size > 5 || size < 0) {
					System.out.println("Sorry, not a valid table size from 1 to 5. Try again.");
					System.out.print("Please enter the table size from 1 to 5 (0 to quit): ");
					size = scan.nextInt(); }
		
		if (size ==5 ) {
		for (int horiz = 1; horiz <=size; horiz++) {
			System.out.print(horiz + "|" + "\t"); 
				System.out.print(horiz + "\t");
		for (int horiz2 = (horiz*2); horiz2 <= (size*2); horiz2 +=100)
		System.out.print(horiz2 + "\t");
		for (int horiz3 = (horiz*3); horiz3 <= (size*3); horiz3 +=100)
		System.out.print(horiz3 + "\t");
		for (int horiz4 = (horiz*4); horiz4 <= (size*4); horiz4 +=100)
			System.out.print(horiz4 + "\t");
		for (int horiz5 = (horiz*5); horiz5 <= (size*5); horiz5 +=100)
				System.out.println(horiz5 + "\t");
			}
		}
		else if (size == 4) {
			for (int horiz = 1; horiz <=size; horiz++) {
				System.out.print(horiz + "|" + "\t"); 
				System.out.print(horiz + "\t");
		for (int horiz2 = (horiz*2); horiz2 <= (size*2); horiz2 +=100)
		System.out.print(horiz2 + "\t");
		for (int horiz3 = (horiz*3); horiz3 <= (size*3); horiz3 +=100)
		System.out.print(horiz3 + "\t");
		for (int horiz4 = (horiz*4); horiz4 <= (size*4); horiz4 +=100)
			System.out.println(horiz4 + "\t");
			}
		}
		else if (size ==3 ) {
			for (int horiz = 1; horiz <=size; horiz++) {
				System.out.print(horiz + "|" + "\t"); 
				System.out.print(horiz + "\t");
		for (int horiz2 = (horiz*2); horiz2 <= (size*2); horiz2 +=100)
		System.out.print(horiz2 + "\t");
		for (int horiz3 = (horiz*3); horiz3 <= (size*3); horiz3 +=100)
		System.out.println(horiz3 + "\t");
			}
		}
		else if (size ==2)
			for (int horiz = 1; horiz <=size; horiz++) {
				System.out.print(horiz + "|" + "\t"); 
				System.out.print(horiz + "\t");
		for (int horiz2 = (horiz*2); horiz2 <= (size*2); horiz2 +=100)
		System.out.println(horiz2 + "\t");
			}
		else if (size ==1)
			for (int horiz = 1; horiz <=size; horiz++) {
				System.out.print(horiz + "|" + "\t"); 
				System.out.print(horiz + "\t");
			} 
		System.out.print("Please enter the table size from 1 to 5 (0 to quit): ");
		size = scan.nextInt(); }

		System.out.println("\nDone!");
				
	}
}

/*Output:Please enter the table size from 1 to 5 (0 to quit): 5
-	-	-	-	-	
1|	1	2	3	4	5	
2|	2	4	6	8	10	
3|	3	6	9	12	15	
4|	4	8	12	16	20	
5|	5	10	15	20	25	
Please enter the table size from 1 to 5 (0 to quit): 3
1|	1	2	3	
2|	2	4	6	
3|	3	6	9	
Please enter the table size from 1 to 5 (0 to quit): 10
Sorry, not a valid table size from 1 to 5. Try again.
Please enter the table size from 1 to 5 (0 to quit): 2
1|	1	2	
2|	2	4	
Please enter the table size from 1 to 5 (0 to quit): 0

Done!
*/