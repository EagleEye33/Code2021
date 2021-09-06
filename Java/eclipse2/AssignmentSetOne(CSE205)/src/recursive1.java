public class recursive1 {
	
	
	int factorial(int n)
	{
		if(n == 1||n==0)
			return 1;
		return factorial(n-1)*n;
	}

public static void main(String args[])
{
	recursive1 nn = new recursive1();
	System.out.println(nn.factorial(3));
}
}