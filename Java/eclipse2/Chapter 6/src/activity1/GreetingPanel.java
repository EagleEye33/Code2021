// Program Name:  GreetingPanel.java  - Starting Code 
	// Author : P Baker and Wyatt Colyn
	// Date : April 11, 2018
	//
	// Brief Description:  User puts their name in the JTextField.  When the
    //                       button is clicked, the name is retrieved and 
    //                       a nice message is displayed by setting the
    //                       text of a JLabel.
	//********************************************************************
	package activity1;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	

	public class GreetingPanel extends JPanel
	{
	   private String Name;
	   private JLabel questionLabel;  
	   private JTextField answerTextField;
	   private JButton button;
	   private JLabel niceMessageLabel;
	     

	 	//Constructor:  Sets up the Panel  
	   public GreetingPanel()
	   {
		   Name = new String();
		   questionLabel = new JLabel("What is your name?");
		   niceMessageLabel = new JLabel(" ");
		   answerTextField = new JTextField();
		   answerTextField.setText("           ");
	
			
			//create all the panel components
			        
		    button = new JButton("Press Here!");
			
			//add all the components to panel.  order is important
		   add(questionLabel);
		   
			add(answerTextField);	
		    add(button); 
		    add(niceMessageLabel);
		   
	        //connect event handler to event source
	        button.addActionListener(new ButtonListener());
					
			//configure panel.  
	        setBackground(Color.LIGHT_GRAY);
	        setPreferredSize(new Dimension(170, 200));
		  
	   }

	   //private internal class that is a listener for button push (action) events.
		//also called an event handler
		private class ButtonListener implements ActionListener
	   {
	      public void actionPerformed (ActionEvent event)
	      {
	    	   //get the name the user put in the answerTextField
	    	  String stranswerTextField = answerTextField.getText();
	    	   
	    	   
	    	   //now set the text of the niceMessageLabel 
	    	   //to a nice message that includes the name 
	    	
			niceMessageLabel.setText("Hello, " + stranswerTextField);
	           
				  
				  
	      }//end of ActionPerformed method
			
	   }//end of ButtonListener
		
	}//end of GreetingPanel

