/*Program Name: Paint.java
 * Author: Wyatt Colyn
 * Date: February 1, 2018
 * Brief Description: Calculates gallons of paint needed for a rectangular room with windows and doors
 */
package chp2;

/**********************************************************
//In class Activity - ch 2  
//Program Name : Paint.java
//
//Author:
//Date Written : 
//Class:
//
//Brief Description:
//Determine how much paint is needed to paint the walls
//of a room given its length, width, and height in feet
//**********************************************************
 * 
 */
import java.util.Scanner;

public class Paint 
{
public static void main(String[] args)
{
			final int COVERAGE = 350;  //paint covers 350 sq ft/gal

		Scanner scan = new Scanner(System.in);

		//declare double  variables for  length, width, height, totalSqFt, and paintNeeded;
		double length;
		double width;
		double height;
		double totalSqFt;
		double paintNeeded; 
		int doors;
		int windows;



		 //Prompt for and read in the length of the room
	System.out.print ("Enter the length of the room: ");
	length = scan.nextDouble();

		 //Prompt for and read in the width of the room
	System.out.print ("Enter the width of the room: ");
	width = scan.nextDouble();


		 //Prompt for and read in the height of the room
	System.out.print ("Enter the height of the room: ");
	height = scan.nextDouble();
	
	System.out.print("Enter the amount of doors: ");
	doors = scan.nextInt();
	
	System.out.print("Enter the amount of windows: ");
	
	windows = scan.nextInt();



	/*Compute the total square feet to be painted--think
 		about the dimensions of each wall*/
	totalSqFt=((2*length) + 2*width)*height - (doors*20) - (windows*15);
 
//Compute the amount of paint needed
paintNeeded=totalSqFt/COVERAGE;

//display your results  
System.out.println();System.out.println(paintNeeded+" gallons of paint are needed to "+"paint a room "+width+" feet wide by ");System.out.println(length+" feet long by "+height+" feet high " + "with " + doors + " doors " + "and " + windows + " window ");



	}

}

/*Output with challenge:
 * 
 * Enter the length of the room: 25
Enter the width of the room: 20
Enter the height of the room: 10
Enter the amount of doors: 1
Enter the amount of windows: 2

2.4285714285714284 gallons of paint are needed to paint a room 20.0 feet wide by 
25.0 feet long by 10.0 feet high with 1 doors and 2 window
*/ 



