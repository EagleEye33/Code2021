// ****************************************************************
// Class Name :  LoveJava.java
// Author : Wyatt Colyn
// Date Written : 2/15/18
// Class : CSC110 or CIS163
// Brief Description:  Use a while loop to print many messages 
//                     declaring your passion for Java
// ****************************************************************
import java.util.Scanner;

public class LoveJava
{
    public static void main(String[] args)
    {
	   int limit = 5;
    	int count ;
    	int sum = 0;
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("How many times do you want to print the message?: ");
		limit = scanner.nextInt();
		
		count = 1;
		while (count <= limit)
		{
		    System.out.println(count + " I love Java!! This number is" + ((count % 2 == 0) ? " even" : " odd") + ".");
		    sum += count;
		    count++;
		}
		
		System.out.println("Message was printed " + (count -1) + " times");
		System.out.println("The sum of the numbers from 1 to " + limit + " is " + sum + ".");
		scanner.close();
    }
}