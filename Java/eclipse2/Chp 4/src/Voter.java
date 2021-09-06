/* Introducing If statements

		Conditions
		Comparison operators > < >= <= != ==

		using the else statement rather than 2 if statements
		short-circuit evaluation


		Scenario:  you can vote if you are 18 or older.
		Enter age and then display appropriate message.

		Using Scanner method nextInt() to retrieve the age that is entered.

 */

 import java.util.Scanner;

 public class Voter
{

	public static void main(String[] args)
    {
		int age;

		Scanner scan = new Scanner(System.in);

		System.out.print ("Enter your age: ");
		age = scan.nextInt();
		

		/*using an if..else statement,
		  to display message
	 	*/

		if(age > 18) {
			System.out.println("Congrats, you can vote");
		} else if(age == 18 ) {
			System.out.println("Have you registered, because you can vote.");
		} else {
			System.out.println("Sorry, you can't vote yet");
		}

	}

}