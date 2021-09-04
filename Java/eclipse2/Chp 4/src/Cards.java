	/* Program Name: Cards.java
	//
	// Author : Wyatt Colyn
	// Date Written : Feb 22, 2018
	//
	// Brief Description:
	// Displays a random card
	*/  
import java.util.Random;
public class Cards {

	public static void main(String[] args) {
		
		int num1, num2, num3; 
		String suit, value;
		suit = "suit";
		value = "value";
		Random generator = new Random();

		num1 = generator.nextInt(4) + 1;
		
		switch (num1)
		{

			case 1:
				suit = "hearts";
				break;
			case 2:
				suit = "spades";
				break;
			case 3:
				suit = "clubs";
				break;
			case 4:
				suit = "diamonds";
				break;
			default:
	}
		num2 = generator.nextInt(13) + 1;
		
		switch(num2)
		{
		case 1:
			value = "ace";
			break;
		case 2:
			value = "2";
			break;
		case 3:
			value = "3";
			break;
		case 4:
			value = "4";
			break;
		case 5:
			value = "5";
			break;
		case 6:
			value = "6";
			break;
		case 7:
			value = "7";
			break;
		case 8:
			value = "8";
			break;
		case 9:
			value = "9";
			break;
		case 10:
			value = "10";
			break;
		case 11:
			value = "jack";
			break;
		case 12:
			value = "queen";
		case 13:
			value = "king";
			break;

		}
		System.out.println("You have selected the " + value + " of " + suit);

}
}
/*Output:
You have selected the 5 of diamonds
You have selected the king of hearts
*/