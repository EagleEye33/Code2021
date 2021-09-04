package activity1;//********************************************************************
//Chapter 6 Activity 4 - DiePanel Starting File 
//Program Name:  DiePanel.java      
//Author : P Baker 

//
//Brief Description :  A graphical user interface
//       and an event listener. Frames, Panels, labels,
//       textfields, buttons for the Die class
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DiePanel extends JPanel
{
  private int countSnakeEyes;
	private Die die1;
	private Die die2;
	
	
	private JLabel titleLabel;
	private JLabel die1FaceValueLabel;  
	private JLabel die2FaceValueLabel;
	private JLabel statusLabel;
	private JLabel countLabel;
	
	
	private JTextField die1FaceValueField;
	private JTextField die2FaceValueField;
	private JTextField statusField;
	private JTextField countField;
	
	
	private JButton rollButton;
	


//-----------------------------------------------------------------
//Constructor: Sets up the GUI.
//-----------------------------------------------------------------
public DiePanel ()
{
 		countSnakeEyes = 0;
	    die1 = new Die();
 		die2 = new Die();
	  
	   
		//create labels
		titleLabel = new JLabel("Dice Game by you");
		die1FaceValueLabel = new JLabel("Die #1: ");
		die2FaceValueLabel = new JLabel("Die #2: ");
		statusLabel = new JLabel("Snake Eyes?");
		countLabel = new JLabel("Count Snake Eyes: ");
		
		
		
		//create textfields and assign initial values
		die1FaceValueField = new JTextField(5);
		die2FaceValueField  = new JTextField(5);
		
		die1FaceValueField.setText(" ");
		die2FaceValueField.setText(" ");

		
		statusField = new JTextField(5);
		statusField.setText("?????");
		countField = new JTextField(5);
		//set up buttons and register with ActionListener
		rollButton = new JButton("Roll Some Dice!!");
		rollButton.addActionListener(new ButtonListener());

	     
      //add the components to the panel.  Order is important
		add(titleLabel);
		
		add(rollButton);
		
		add(die1FaceValueLabel);
		add(die1FaceValueField);
		add(die2FaceValueLabel);
		add(die2FaceValueField);
		
		add(statusLabel);
		add(statusField);
		
		add(countLabel);
		add(countField);
		
		setBackground (Color.cyan);
		setPreferredSize (new Dimension(135, 200));
}

//*****************************************************************
//Represents a listener for button push (action) events.
//*****************************************************************
private class ButtonListener implements ActionListener
{
 //--------------------------------------------------------------
 //  Updates the counter and textField when the button is pushed.
 //--------------------------------------------------------------
 public void actionPerformed (ActionEvent event)
 {
		
					    
		   if (event.getSource() == rollButton)
			{
				die1.roll();
				die2.roll();
				
				die1FaceValueField.setText(Integer.toString(die1.getFaceValue()));
				die2FaceValueField.setText(Integer.toString(die2.getFaceValue()));
				
				if(die1.getFaceValue() == 1 && die2.getFaceValue() == 1) {
					statusField.setText("YES!");
					setBackground(Color.yellow);
					countSnakeEyes++;
				} else {
					statusField.setText("NO!");
					setBackground(Color.cyan);
					
				}
				countField.setText(Integer.toString(countSnakeEyes));
			}
			
			
			
			
 }//end of actionPerformed method
		
}//end of ButtonListener
	
}//end of DiePanel
