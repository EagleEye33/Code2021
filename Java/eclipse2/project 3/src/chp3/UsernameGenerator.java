/*Program Name: UsernameGenerator.java
 * Author: Wyatt Colyn
 * Date: February 11, 2018
 * Brief Description: Generates a random username. 
 */
package chp3;
import java.util.Random;
import java.util.Scanner;
public class UsernameGenerator {

	public static void main(String[] args) {
		
		System.out.println("Welcome. This program will help you create a username.");
		
		Random generator = new Random();
		
		Scanner scan = new Scanner(System.in);
		
		String firstname, lastname, birthyear, birthcity, username1, username2, username3;
		int num1, num2;
		
		
		System.out.print("Enter your first name: ");
		firstname = scan.nextLine();
		System.out.print("Enter your last name: ");
		lastname = scan.nextLine();
		System.out.print("Enter your birth year: ");
		birthyear = scan.nextLine();
		System.out.print("Enter your birth city: ");
		birthcity = scan.nextLine();
		
	     if(birthcity.contains(" ")){
	        birthcity = birthcity.substring(0, birthcity.indexOf(" ")); 
	     }else {
	    	 birthcity = birthcity;
	     }
	     
		num1 = generator.nextInt(101) + 1;
		num2 = generator.nextInt(26) + 50;
		
		username1 = firstname.substring(0,1) + lastname + birthyear.substring(2,4) + num1;
		username2 = firstname.substring(1,2) + lastname.substring(0,1) + birthcity + num2;
		username3 = lastname.substring(0,3) + firstname.substring(firstname.length() - 2) + birthyear.substring(0,2);
		
		System.out.println("\n" + "Here are the three usernames generated for you: \n" +
		username1 + "\n" +
		username2 + "\n" +  
		username3);
		
		
		
		
	}

}

/*Output 1:
 * Welcome. This program will help you create a username.
Enter your first name: mike
Enter your last name: smith
Enter your birth year: 1994
Enter your birth city: los angeles

Here are the three usernames generated for you: 
msmith9451
islos60
smike19

Output 2:
Welcome. This program will help you create a username.
Enter your first name: wyatt
Enter your last name: colyn
Enter your birth year: 1998
Enter your birth city: chandler

Here are the three usernames generated for you: 
wcolyn9846
ycchandler66
coltt19

 * */
