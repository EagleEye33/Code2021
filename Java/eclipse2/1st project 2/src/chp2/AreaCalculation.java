package chp2;
//In Class Activity .  Ch 2
//Program Name : AreaCalculation
//Author : 
//Date Written: 
//Class : 
//Brief Description:  
//        This program calculates the area of a rectangle.


import java.util.Scanner;  //Needed for the Scanner class


public class AreaCalculation
{

	public static void main(String[] args)  //all the action happens here!
	{

		 //define all variables and assign values
		 int length;
		 int width;
		 int area;
		 Scanner scanner;
		 scanner = new Scanner(System.in);
		 
		 //prompt
		 System.out.print("Input length: ");
		 length = scanner.nextInt();

		 //prompt
		 System.out.print("Input width: ");
		 width = scanner.nextInt();

		  //perform area calculation 
		 area = length * width;

		 //now display your answer
		 System.out.println("The area is:  " + area);


	} //end of the main method


} // end of the class 


