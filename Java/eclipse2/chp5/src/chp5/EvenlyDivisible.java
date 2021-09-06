package chp5;

public class EvenlyDivisible {
	
	int num1 = 0; 
	int num2 = 0;
	
	public boolean evenlyDivisible(int num1, int num2)
	{
		if (num1%num2 == 0 && num2%num1 == 0)
			return true;
		else
			return false;
	}

}
