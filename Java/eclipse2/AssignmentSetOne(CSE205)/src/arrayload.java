import java.util.Scanner;
public class arrayload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int numberload;

		Scanner scan = new Scanner(System.in);
		System.out.println("How many numbers do you want to load?");
		numberload = scan.nextInt();
		
		int[] numberloadee = new int[numberload];

		for(int i=0; i<numberload; i++) {
			System.out.println("Enter your numbers");
			numberloadee[i] = scan.nextInt();
		}
		scan.close();
		
		System.out.println("those numbers are");
		for(int j=0; j<numberload; j++)
		{
			System.out.println(numberloadee[j]);
		}
		
		
	}

}
