/* 
  Program Name : MorePredefinedClasses1.java
  Author : P Baker
  Date Written : 
  Class : CSC110AA and CIS163AA
  
  Brief Description: 
		   Ch 3 -  Introduces some more predefined classes
		  -String
		  -Random
		  
  */
package chp3;
 import java.util.Random;
 import java.util.Scanner;

  public class MorePredefinedClasses1
  {

	  	public static void main(String[] args)
	  	{
	  		//declare variables
	  		int num1;
	  		double num2;
	  		String word;
	  		String firstName;
	  		
	  		//declare and instantiate a Scanner object
	  		Scanner scan = new Scanner(System.in); 
	  		//declare and instantiate a Random object
	  		Random generator = new Random();
	  	
			/* Example: Using the String Class  - Ch 3.2 in text
	  		   Step 1.  don't have to import the String class - always available
	  		   Step 2.  Declare and instantiate a String object
	  		   Step 3.  Use the length method
	      */
		
	   	    word = new String("College");
			word = "College";  //same as above
			System.out.println("The length of " + word + " is: " + word.length()  );
			System.out.println("The first 3 letters of " + word +  " are: " + word.substring(0,3) );
			
			//Another String example. Prompt the user for their first name
			System.out.print("Enter your first name: ");
			firstName = scan.next();
			System.out.println("Your first name is: " + firstName);
	
	  		/* Example: Randomly generate any valid integer  Ch 3.4 in text
	  		   Step 1.  import java.util.Random
	  		   Step 2.  Declare and instantiate a Random object
	  		   Step 3.  Use the nextInt method
	  		*/
	
	  		 num1 = generator.nextInt();
			 System.out.println("Any valid integer: " + num1);
	
	
	  		 /* Example:  Generate a random integer from 0 to 5
			 	 Use the generator object already created.
			 	 Use the nextInt method with a parameter
			 	 Hint:  nextInt(n) returns numbers 0 to n-1
	  		 */
	  		 num1 = generator.nextInt(6);
	  		 System.out.println("Number  from 0 to 5: " + num1);
	
	
	  		 /* Example:  Generate a random integer from 1 to 5
	  		 	 Call the nextInt method with a new parameter
	  		 */
	  		 int num3 = generator.nextInt(5) + 1;
	  		 System.out.println("Number from 1 to 5: " + num3);
	  		 // num1 = 
	  		 // System.out.println("Number  from 1 to 5: " + num1);
	
	
			  /* Example:  Generate a double between 0.0 - 0.999999
			     Use the nextDouble() method
			  */
	
			   double num4 = generator.nextDouble(); 
			   System.out.println("Number from 0.0 to 0.9999: " + num4);
	
	
			   /*Example:  Generate a double from 0.0 - 99.9999
			   */
			   double num5 = generator.nextDouble() * 100;
			   System.out.println("number from 0 - 99.9999: " + num5);
			  //  num2 = 
			   // System.out.println("Number from 0 - 99.9999: " + num2);
	
	
			   	
	
		  }
	
 }
