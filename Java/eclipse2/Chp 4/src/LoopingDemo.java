/* Program Name :  LoopingDemo
   
	We will use this demo to look at 3 different looping constructs
		    while
		    do..while
		    for

    [1] With each looping construct we will display 12345

    [2] Show how to add up numbers 1- 5 in loop

    [3] Nested for loop

    Patricia Baker
  */

public class LoopingDemo
{

	public static void main (String[] args)
	{


		/* Review the while loop.  It displays 1 -  5 */

		System.out.println("\n*****while loop******");
		int counter = 1;
		while (counter <= 5)   //displays 1 - 5
		 { 
			System.out.print(counter + "\t");
			counter++;
		}


		System.out.println();

		int sum1 = 0;
		System.out.println("\n*****for loop******");
		for(counter = 1; counter<=5; counter++) {
			System.out.print(counter + "\t");
		}




		System.out.println();

		System.out.println("\n*****do..while loop******");
		counter = 1;
		do {
			System.out.print(counter + "\t");
			counter++;
		} while (counter<= 5);





		System.out.println();
		int sum = 0;
		for (int x = 1; x <=5; x++)	{
				sum += x;
				
		}
		System.out.println(sum);
		

		/*
		  Nested for loops.  Creating 6 rows of numbers 1 - 5

		 */

		
		System.out.println("\n*****nested for loop******");
		for(int x = 1; x <=5; x++) {
			
			System.out.print(x + " - ");
			
			for(int y=1; y<=5; y++) {
				
				System.out.print(y + "\t");
		}
			System.out.println();
    }
	



	for(int x = 1; x <= 4; x++) {
		
		for(int y = 1; y <= x; y++) {
		System.out.print(x);
		}
		System.out.println();
		}
	
	int count = 2; 
	for (count = 0; (count < 1000); count ++);
	System.out.println(count);
	
	
}
}