package demo1;
/* Program ID:  Statistics Array with Exceptions Starting File
* Class:  CSC110AA/CIS163AA
* Date : April 25, 2018
* Author:  Patricia Baker and Wyatt Colyn
*
*  Brief Description:  Defines a class that has a 10 element integer array
*  Methods perform tasks for the array - find max, sum, find average, etc
*  
*/

import java.awt.*;
import java.util.Random;  //for our random number generator
import java.util.Scanner;




public class StatsArray {

	private int size;  //how big is the array
	private int[ ] stats; // an array of integers


	//default constructor 
	StatsArray() {
		size = 10;
		stats = new int[size];
	}


	public void display(Graphics g)
  {
		int x = 50;  //coordinates for displaying
		int y = 40;
		//display the array with position number
		for(int i = 0; i < stats.length; i++)
		 {
			g.drawString("Stats [" + i + "] = "+ stats[i], 
			x, (y + 15 * i) );
		}
	}

	public void fillArray()
	{
		//fill the array with random numbers (int) in the range 0 - 100
		Random random = new Random();
		for(int i = 0; i < stats.length; i++)
		 {
			stats[i] = random.nextInt(101) ;
      }
	}

	public void fillArrayFromUser()
	{
		int i = 0;
		String input;
		do
		{
		try
		{
			System.out.println("Enter a value");
			Scanner Scan= new Scanner(System.in);
			input = Scan.next();
			int iValue = Integer.parseInt(input);
			checkIfNegative(iValue);
			stats[i] = iValue;
			i++;
			}

		catch (NumberFormatException e) 
		{
			System.err.println("Invalid value please enter an integer");
			}

		catch (IllegalArgumentException e)
		{
			System.err.println("Negative value not allowed");
			}
		}
			while (i < stats.length);
		}		

		public void checkIfNegative(int someValue)
			{
			if (someValue < 0)
				{
			throw new IllegalArgumentException( );
					}

			}

			public void displayOut()
					{
				for(int i = 0; i < stats.length; i++)
					{
						System.out.println(stats[i]);
						}
				}
	public int getSum()
	{
		//add up all the values in the array
		int total = 0;
		for (int i = 0; i < stats.length; i++)
			total = total + stats[i];
		return total;
	}


	public int getMax() 
	{
		//return the maximum value in the array
			int maxValue = stats[0];
			for (int i = 0; i < stats.length; i++){
				if (stats[i] > maxValue)
					maxValue = stats[i];
			}
			return maxValue;
	}

	public int getMin() 
	{
		//return the minimum value in the array
			int minValue = stats[0];
			for (int i = 0; i < stats.length; i++){
				if (stats[i] < minValue)
					minValue = stats[i];
			}
			return minValue;
	}

	public double getAverage() 
	{
		//return the average.  must be a double
			return (double)getSum() / stats.length;
	}

	public int countValues(int lowRange, int highRange) 
	{
		//count how many numbers are >= lowRange and <= highRange
		int count = 0;
		for (int i = 0; i < stats.length; i++) {
			if ( (stats[i] >= lowRange) && (stats[i] <= highRange) ) 
			{
				count++;
			}
		}
		return count;
	}


	public boolean isValueFound(int someNumber) {
		//check to see if someNumber is in the array
		boolean found = false;

		for(int i = 0; (i < stats.length && !found); i++) {
			if (stats[i] == someNumber) {
				found = true;
			}
		}
		return found;
	}


	public void sortBArray() {
		/*sort the array in ascending order - bubble sort*/

		int tempValue;

		for (int i = 0; i < (stats.length - 1); i++)
		{
			for (int j = (i + 1); j < (stats.length); j++)
			{
				if (stats[j] < stats[i])
				{
					tempValue = stats[i];
					stats[i] = stats[j];
					stats[j] = tempValue;
				}
			}
		}

	}


   public void sortArray() {
			/*sort the array in ascending order - selection sort*/

			int tempValue;
			int min;

			for (int i = 0; i < (stats.length - 1); i++)
			{
				min = i;
				for (int j = (i + 1); j < (stats.length); j++)
				{
					if (stats[j] < stats[min])
					{
						min = j;
					}
				}
				tempValue = stats[min];
				stats[min] = stats[i];
				stats[i] = tempValue;


			}

		}




}