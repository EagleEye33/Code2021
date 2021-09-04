import java.util.Scanner;
public class playAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		String playAgain = "yes";
		while(playAgain.startsWith("y")) {
			playAgain = input.nextLine();
		}
		}

	}


