package chp5;

public class SnakeEyes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int ROLLS = 500;
		int count=0;
		
		Die die1 = new Die();
		Die die2 = new Die();
		
		PairOfDice die3 = new PairOfDice();
		PairOfDice die4 = new PairOfDice();
		
		for (int roll = 1; roll <=ROLLS; roll++)
		{
			die1.roll();
			die2.roll();
			
			if (die1.roll() == 1 && die2.roll() == 1)
				count++;
		}
		System.out.println("Number of rools: " + ROLLS);
		System.out.println("Number of Snake eyes: " + count);
		System.out.println("ratio: " + (float)count/ROLLS);
		
		die3.roll1();
		die4.roll1();
		
		System.out.println(die3);
		System.out.println(die4);
		
		System.out.println(die3.calculate(die3.getDie1(), die3.getDie2()));
		
	}

}
