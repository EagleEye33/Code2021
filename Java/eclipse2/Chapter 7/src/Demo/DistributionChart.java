package Demo;

//********************************************************************
//DistributionChart.java       
//Name: Wyatt Colyn	 
//Date:
//
//
//Design and implement an application called DistributionChart
//that creates a chart/histogram so that you can visually inspect 
//the frequency distribution of a set of values.
//
//
//********************************************************************

import java.util.Scanner;

public class DistributionChart 
{
	

public static void main (String[] args)
{
   int size = 10;
   int[] ranges = new int[size];  // each entry represents a range of values
	     
   getData(ranges);   //pass the entire array into the method
   
   displayChart(ranges);
   
   System.out.println("\nSee you later!!");
   
} //end of main

public static void getData(int[] someArray)
{
	   
	   Scanner scan = new Scanner (System.in);

	   System.out.println ("Enter a series of numbers between 1 and 100. Separate each number with a space.");
	   System.out.println ("Signal the end by entering a number outside " +
	         "of that range.");
	   System.out.print("Go: ");

	   
	   //reads an arbitrary number of integers that are in the range 1 to 100 inclusive
	   //for each integer read in, determine which range it is in and increment the corresponding element in the array
	   	   for ( int counter = 0; counter < someArray.length; counter++ ) {
		 
		   if ( counter == 10 )
		     System.out.printf("\n: ", 100 );
		   else
		     System.out.printf( ": ", counter * 10, counter * 10 + 9 );
	
		     for ( int stars = 0; stars < someArray[ counter ]; stars++ )
		       System.out.print( "*" );
		       System.out.println(); 	   }
	   //your code goes here
		   int counter = scan.nextInt();
	    
	    scan.close();  
}//end of getData

public static void displayChart(int[] someArray)
{
	   //Print chart title with your name
	   
	   //Print histogram.
	      
	     
	      
} //end of displayChart


}// end of DistributionChart tester class

/* Example output.  



*/
