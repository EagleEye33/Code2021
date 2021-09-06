// *
//   Program Name: EnhancedCinemaPrice.java 
//  
//   Author :  Wyatt Colyn
//
//   Date : March 1, 2018
//   Description: Continually calculates cinema price based off age entries
// *
import java.util.Scanner;
import java.text.NumberFormat;

public class EnhancedCinemaPrice
{
	public static void main(String[] args)
	{
		int age = 0;
		double price = 0.0;
		
		Scanner scan = new Scanner(System.in);
		
		NumberFormat nFmt = NumberFormat.getCurrencyInstance();
		
		System.out.print( "Please enter the cinema ticket price: ");
	   price = scan.nextDouble();
	   
	   System.out.print("Please enter your age (0 to quit): ");
	   age = scan.nextInt();
	   
	   	 System.out.println("Your age: " + age);
	   	 	
			while (age != 0) {
				
				if(age <= 5) {
			
			price = 0.0;
			System.out.println("Your ticket price is " + nFmt.format(price) + " which is free.");
			
		} else if (age >5 && age <= 12) {
			
			price /= 2;
			System.out.println("You pay half the ticket price which is " + nFmt.format(price));
			
		} else if (age >12 && age <= 54) {
			
			System.out.println("Your ticket price is " + nFmt.format(price) + " which is full price");
			
		} else {
			price = 0.0;
			System.out.println("Your ticket price is " + nFmt.format(price) + " which is free.");
			
		}   System.out.print( "Please enter the cinema ticket price: ");
			   price = scan.nextDouble();
			   System.out.print("please enter your age(0 to quit): ");
		      age = scan.nextInt();  
		   
	    if(age == 0) {
		   System.out.println("Goodbye");
	}
			}
	}
}
	/* Output: 
Please enter the cinema ticket price: 15
Please enter your age (0 to quit): 24
Your age: 24
Your ticket price is $15.00 which is full price
Please enter the cinema ticket price: 15
please enter your age(0 to quit): 60
Your ticket price is $0.00 which is free.
Please enter the cinema ticket price: 15
please enter your age(0 to quit): 8
You pay half the ticket price which is $7.50
Please enter the cinema ticket price: */