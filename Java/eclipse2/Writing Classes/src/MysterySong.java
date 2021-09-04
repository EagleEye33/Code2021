import java.util.Scanner;

public class MysterySong {


	public static void main(String[] args) {
		
		int value;
		int playagain = 0;
		
		Scanner scan = new Scanner(System.in); 
		do 
		
		{
		System.out.println("Please enter a value 1 through 3 to recieve a mystery song");
		value = scan.nextInt();
		if (value == 1) {
			System.out.print( "Into this world we're thrown, dun dun dun-dunnad-dun");
		
		}else if (value == 2) {
			System.out.println("Come Together! du-du-du-du-du Right Now! du du du du......."
				+ ".... Over me - Shaundandalaaaaa wewerrrr");
		}else if( value == 3) {
			System.out.print("You see I've been through the desert on a horse with no "
				+ "name... it felt good to be out of the rain.. dedelea.. in the desert, "
				+ "you can't remember your name for' there ain't no one to give you no pain."
			);
		}
		System.out.println("\n" + "would you like to play again? 1 for yes 2 for no.");
			playagain = scan.nextInt();
		
		
		}while (playagain == 1); 
		
					
		if (playagain == 2)
			System.out.println("Farewell landstrider.....");
	

	
		
}	
	}
