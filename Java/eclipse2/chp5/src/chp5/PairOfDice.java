package chp5;

public class PairOfDice {

	private int num1, num2;
	
	public PairOfDice()
	{
		this.num1 = 1;
		this.num2 = 1;
	}
	
	public int getDie1()
	{
		return num1;
	}
	public int getDie2()
	{
		return num2;
	}
	
	public void roll1()
	{
		num1 = (int) (Math.random()*6) + 1;
		num2 = (int) (Math.random()*6) +1;
		
	}
	
	
	public void setnum1(int die1)
	{
		if (num1 > 0 && num1 <= 6)
			num1 = die1;
	}
	
	public void setnum2(int die2)
	{
		if (num2 > 0 && num2 <= 6)
			num2 = die2;
	}
	
	public int calculate(int sum1, int sum2)
	{
		return sum1+sum2;
	
		
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("the value of die1 is: " + num1);
		builder.append(", the value of die2 is: " + num2);
		return builder.toString();
	
}

	}

