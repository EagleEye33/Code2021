package activity1;

//********************************************************************
//Program Name:  CarCounterPanel.java  Starting File - CarCounter 1 Activity 
//Author : P Baker / P Jalowiec
//Date : 2011
//
//Brief Description:
//	Demonstrates a graphical user interface and an event listener.
//		Frames, Panels, labels, textfields, buttons
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarCounterPanel extends JPanel
{
private int carCount;
private JLabel carLabel;
	private JTextField carTextField;
	private JButton carButton;

	//Constructor:  Sets up the Panel  
	public CarCounterPanel()
{
   carCount = 0;
		
		//create panel components
		carLabel = new JLabel ("Number of cars: " );
		carTextField = new JTextField(10);
   carButton = new JButton("Press Here!");
		
		//connect event handler to event source
   		carButton.addActionListener(new ButtonListener());
		
		//add components to panel.  order is important
   		add(carLabel);
   		add(carTextField);
   		add(carButton);
		
				
		//configure panel.  
   setBackground(Color.cyan);
   setPreferredSize(new Dimension(300, 200));
		carTextField.setText(Integer.toString(0));
}

//private internal class that isoio a listener for button push (action) events.
	//also called an event handler
	private class ButtonListener implements ActionListener
{
   public void actionPerformed (ActionEvent event)
   {
			//update the counter and the textField with the button is pushed
        	carCount+=1;
        	carTextField.setText(Integer.toString(carCount));
			  
			  
   }//end of ActionPerformed method
		
}//end of ButtonListener
	
}//end of CarCounterPanel