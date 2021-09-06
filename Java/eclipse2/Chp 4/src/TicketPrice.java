//In Class Activity Starting File
//Program ID : TicketPrice.java
//Author : Wyatt Colyn
//Date Written : February 8, 2018
//Class : CSC110AA 
//Brief Description:
//		This program determines ticket price based on age.  Uses an if..else if

import java.util.Scanner;

public class TicketPrice
{
	public static void main(String[] args)
	{
		int age = 0;
		double price = 0.0;
		
		Scanner scan = new Scanner(System.in);
	
		System.out.println( "Movie Ticket Price Calculator");
		
		System.out.print( "Your age: ");
	   age = scan.nextInt();
		
		System.out.print( "Ticket price: ");
	   price = scan.nextDouble();

	
		//calculate the ticket prices and display a message
		// based on your if..else if..else statement

		if(age <= 5) {
			
			price = 0.0;
			System.out.println("You  get in free! ");
			
		} else if (age >=6 && age <= 20) {
			
			price /= 2;
			System.out.println("You pay half price. ");
			
		} else {
			
			System.out.println("You pay full price. ");
		}
		System.out.println("Your ticket price is $" + price);
			}
		
	}
