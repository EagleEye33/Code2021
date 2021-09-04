package demo1;

//********************************************************************
// Program Name:  ExceptionallPanel.java    Starting File for Students  
// Author : P Baker 
// Date : Nov 2008
//
// Brief Description :  Demonstrates handling exceptions
//        
//
//*********************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExceptionalPanel extends JPanel {

	private JButton myButton;
	private JTextField myTextField;
	private JTextField myTextField2;
	private JLabel myLabel, aLabel;

	// -----------------------------------------------------------------
	// Constructor: Sets up the GUI.
	// -----------------------------------------------------------------
	public ExceptionalPanel() {

		// label to write answer
		myLabel = new JLabel("Testing some division ");
		aLabel = new JLabel("Answer");

		// textfields
		myTextField = new JTextField(10);
		myTextField2 = new JTextField(10);

		// button
		myButton = new JButton("Calculate");
		myButton.addActionListener(new ButtonListener());

		add(myLabel);
		add(myTextField);
		add(myTextField2);
		add(myButton);
		add(aLabel);

		setBackground(Color.cyan);
		setPreferredSize(new Dimension(200, 300));

	}

	// *****************************************************************
	// Represents a listener for button push (action) events.
	// *****************************************************************
	private class ButtonListener implements ActionListener {
		// --------------------------------------------------------------
		// Reads values in textFields and completes
		// calculation when the button is pushed.
		// --------------------------------------------------------------
		public void actionPerformed(ActionEvent event) {

			int num1 = Integer.parseInt(myTextField.getText());
			int num2 = Integer.parseInt(myTextField2.getText());
			// checkForTwo(num1);
			// checkForTwo(num2);
			try {
			aLabel.setText("The Answer is: " + num1 / num2);
			} catch (ArithmeticException e) {
				aLabel.setText("Divide by Zero Error");
				e.printStackTrace();
			}
		}// end of ActionPerformed

	}// end of ButtonListener

}// end of ExceptionalPanel
