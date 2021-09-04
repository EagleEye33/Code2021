package demo1;

//********************************************************************
// Program Name:  ExceptionalDemoFrame.java      
// Author : P Baker 
// Date : Nov 2008
//
// Brief Description :  Demonstrates handling exceptions
//        
//*********************************************

import javax.swing.JFrame;

public class ExceptionalDemoFrame {

	// -----------------------------------------------------------------
	// Creates and displays the main program frame.
	// -----------------------------------------------------------------

	public static void main(String[] args) {
		JFrame frame = new JFrame("Exceptions Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ExceptionalPanel panel = new ExceptionalPanel();
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}
