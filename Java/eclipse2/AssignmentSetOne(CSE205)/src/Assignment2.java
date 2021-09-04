	// Assignment #: 2
	// Name        : Wyatt Colyn	
	// StudentID   : 1215474364
	// Lecture     : TTH 4:30-5:45am 
	// Description : Reads an arbitrary number of integers from the user and performs various calculations
	import java.util.Scanner;
	public class Assignment2 {

		public static void main(String[] args) {
			
			int num = 0, value, min=0, num1=0, num2=0, num3=0, num4=0, num5=0, num6=0;
			
			//read in input from the user
			Scanner scan = new Scanner(System.in);
			
			do
		    {	
			 	 value = scan.nextInt();
			 	 num = value;
			 	 //find the minimum value
			 	 if(num < min)
			 	 {
			 		min = num;
			 	 }
			 	 
			 	 num1 = value;
			 	 //add up all positive even integers
			 	 if(num1%2 == 0 && num1 > 0)
			 	 {
			 		 num2 = num2 + num1;
			 	 }
			 	 
			 	 num3 = value;
			 	 //count all of the negative integers
			 	 if(num3 < 0)
			 	 {
			 		 num6+=1;
			 	 }
			 	 
			 	 num4 = value;
			 	 //add up all the numbers that are divisible by 3
			 	 if(num4%3 == 0)
			 	 {
			 		 num5 = num5 + num4;
			 	 }
			 	 //Terminate the loop if user inputs 0
			} while (value != 0);
			
					System.out.println("The minimum integer is " + min + "\n" + "The sum of positive even integers is " + num2 + "\n" + 
					"The count of negative integers is " + num6 + "\n" + "The sum of numbers divisible by 3 is " + num5);
		}

	}