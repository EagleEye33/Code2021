public class countdigits {
	
	public static void main(String[] args){
		int n = 153;
		int sum = 0;
		int digit;
		
		while(n != 0)
		{
			digit  = n % 10;
			sum = sum + digit; 
			n = n / 10;
		}
	System.out.println("the sum is " + sum);
	}
}