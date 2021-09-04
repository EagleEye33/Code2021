import java.util.Scanner;

public class MysterySong2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Lyrics MysterySong = new Lyrics();
		
		int value;
		int playagain = 0;
		
		Scanner scan = new Scanner(System.in); 
		
		do 
		
		{
		System.out.println("Please enter a value 1 through 3 to recieve a mystery song");
		value = scan.nextInt();
		if (value == 1) {
				System.out.println(MysterySong.getsongLyrics1());
		
		}else if (value == 2) {
			
			System.out.println(MysterySong.getsongLyrics2());
			
		}else if (value == 3) {
			
			System.out.println(MysterySong.getsongLyrics3());
		}
		System.out.println("\n" + "would you like to play again? 1 for yes 2 for no.");
			playagain = scan.nextInt();
		
		
		}while (playagain == 1); 
		
					
		if (playagain == 2)
			System.out.println("Farewell landstrider.....");
	

	
	


	
}
	
}