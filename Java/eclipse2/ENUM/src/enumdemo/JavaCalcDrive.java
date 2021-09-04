package enumdemo;

import javax.swing.JFrame;

public class JavaCalcDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaCalculator calc = new JavaCalculator();

		calc.setLocationRelativeTo(null);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		calc.pack();
		calc.setVisible(true);
	}

} // JavaCalculator
