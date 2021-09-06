// *
//   Program Name: JellyBeanGame.java 
//  
//   Author :  Wyatt Colyn
//
//   Date : March 1, 2018
//   Description:
//   Play a game where the user tries to guess the
//   number of jellybeans in a jar.  Can range from 1 to 1000
//   
//   Uses a do..while loop.
//
// *
import java.util.Scanner;
import java.util.Random;

public class JellyBeanGame
{
    public static void main(String[] args)
    {
        int numOfJellyBeans = 0;       //Number of jellybeans in jar
        int guess = 0;                       //The user's guess
       int numGuess = 0;
       int playAgain = 0;

		 Random generator = new Random();
		 Scanner scan = new Scanner (System.in);

		//randomly generate the number of jellybeans in jar
		 
		 numOfJellyBeans = generator.nextInt(1001) +1;

		System.out.println("There are between 1 and 1000 jellybeans in the jar,");
		
	
		
	do
    {
	    //prompt user to quess and read in 
		 System.out.println("Enter your guess: ");
		 	guess = scan.nextInt();
		
		  if (guess > numOfJellyBeans) {
			 	System.out.println("Too High!");
			 numGuess++;
		 }else if (guess < numOfJellyBeans) {
			 System.out.println("Too Low!");
			 numGuess++;
		 }
		 //if the quess is wrong display message
		 
	}	while (guess != numOfJellyBeans);
	
		if (guess == numOfJellyBeans) {
			numGuess++;
		
			System.out.println("High Five! You got it, after " + numGuess + " guesses!!");
			System.out.println("Play again? 1 for yes or 2 for no: ");
			playAgain = scan.nextInt();
		}
   // display message saying guess is correct
			while (playAgain == 1) {
				 numOfJellyBeans = generator.nextInt(1001) +1;

					System.out.println("There are between 1 and 1000 jellybeans in the jar,");
				
					numGuess = 0;
					
				do
			    {	
				
				    //prompt user to quess and read in 
					 System.out.println("Enter your guess: ");
					 	guess = scan.nextInt();
					
					  if (guess > numOfJellyBeans) {
						 	System.out.println("Too High!");
						 numGuess++;
					 }else if (guess < numOfJellyBeans) {
						 System.out.println("Too Low!");
						 numGuess++;
					 }
					 //if the quess is wrong display message
					 
				}	while (guess != numOfJellyBeans);
				
					if (guess == numOfJellyBeans) {
						numGuess++;
					
						System.out.println("High Five! You got it, after " + numGuess + " guesses!!");
						System.out.println("Play again? 1 for yes or 2 for no: ");
						playAgain = scan.nextInt();
					}
			} if (playAgain == 2)
				System.out.println("see you later!");
    

    }
}
/* Output:
There are between 1 and 1000 jellybeans in the jar,
Enter your guess: 
500
Too High!
Enter your guess: 
	400
Too High!
Enter your guess: 
	200
Too Low!
Enter your guess: 
	300
Too Low!
Enter your guess: 
	350
Too Low!
Enter your guess: 
	360
Too Low!
Enter your guess: 
	370
Too Low!
Enter your guess: 
	380
Too Low!
Enter your guess: 
	390
Too High!
Enter your guess: 
	385
Too High!
Enter your guess: 
	384
Too High!
Enter your guess: 
	383
Too High!
Enter your guess: 
	382
Too High!
Enter your guess: 
	381
High Five! You got it, after 14 guesses!!
Play again? 1 for yes or 2 for no: 
	1
There are between 1 and 1000 jellybeans in the jar,
Enter your guess: 
	500
Too High!
Enter your guess: 

400
Too High!
Enter your guess: 
	200
Too Low!
Enter your guess: 
	300
Too High!
Enter your guess: 
	250
Too Low!
Enter your guess: 
	260
Too Low!
Enter your guess: 
	270
Too Low!
Enter your guess: 
	280
Too Low!
Enter your guess: 
	290
Too Low!
Enter your guess: 
	295
Too Low!
Enter your guess: 
	299
Too High!
Enter your guess: 
	298
Too High!
Enter your guess: 
	297
High Five! You got it, after 13 guesses!!
Play again? 1 for yes or 2 for no: 
	2
see you later!
*/