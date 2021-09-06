import java.io.IOException;
import java.util.Scanner;
// Assignment #: ASU CSE205 Assignment #9
//         Name: Wyatt Colyn			
//    StudentID: 121-547-4364
//      Lecture: TTh 4:30-5:45 p.m
//  Description: this program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the largest number, the count of even numbers (includes both positive and negative),
//  the number of -1 inside the array, and also compute the sum of numbers at
//  odd indexes (i.e. 0, 2, 4, ...), using recursion.
public class Assignment9
{
/******************************************************************************
  ***Complete the main() method. See above program description for details.
******************************************************************************/
  public static void main (String[] args) throws IOException
  {
	  Scanner scan = new Scanner(System.in);
	  int end;
	  int arr[] = new int[20];
	  int i=0;
	  do
	  {
		  arr[i] = scan.nextInt();
		  end = arr[i];
		  i++;
	  }while(end != 0);
	  
	  System.out.println("The largest number is " + findMax(arr, 0, i-1));
	  System.out.println("The total number of even integers is " + countEven(arr, 0, i-1));
	  System.out.println("The total number of -1 is " + countNegativeOne(arr, i-1));
	  System.out.println("The sum of numbers at odd indexes is " + computeSumAtOddIndexes(arr, i-1));
	  scan.close();
  }
/*************************************************************************************
***(1)Complete the method. The method finds the largest number in the partial array
***range from startIndex to endIndex
*************************************************************************************/
public static int findMax(int[ ] numbers, int startIndex, int endIndex)
{
	if(startIndex == endIndex)
		return numbers[startIndex];
	
	if(numbers[startIndex] > numbers[endIndex])
		return findMax(numbers, startIndex, endIndex-1);
	else
	return findMax(numbers, startIndex+1, endIndex);
}
/**************************************************************************************
***(2)Complete the method. The method counts the number of even integers in the partial
***arrya range from startIndex to endIndex
*************************************************************************************/
public static int countEven(int[ ] numbers, int startIndex, int endIndex)
{
	 if (endIndex < startIndex)
		 return 0;
	 if (numbers[endIndex] % 2 == 0 && numbers[endIndex] != 0) 
	     return 1 + countEven(numbers, startIndex, endIndex - 1);
	 else
	 return countEven(numbers, startIndex, endIndex -1);	    	    
}
/*************************************************************************************
***(3)Complete the method. The method counts the number of -1 inside an array with
***   "count" numbers, index ranges from 0 to count-1
*************************************************************************************/
public static int countNegativeOne(int[ ] numbers, int count)
{
	if(count == -1)
		return 0;
	if(numbers[count] == -1)
		return 1 + countNegativeOne(numbers, count-1);
	else
	return countNegativeOne(numbers, count-1);
}
/**************************************************************************************
***(4)Complete the method. The method computes the sum of numbers at index 1, 3, 5, ...
***  inside a partial array with "count" numbers inside, index ranges from 0 to count-1
***************************************************************************************/
public static int computeSumAtOddIndexes(int[ ] numbers, int count)
{
	if(count == -1)
		return 0;
	if(count%2 == 1)
		return numbers[count] + computeSumAtOddIndexes(numbers, count-1); 
	else
	return computeSumAtOddIndexes(numbers, count-1);
}

}// end of class Assignment9