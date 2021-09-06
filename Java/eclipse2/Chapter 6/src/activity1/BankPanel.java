package activity1;
/*Program name: BankPanel.java
 * Author: Wyatt Colyn
 * Date written: April 11, 2018
 * Brief Description: Cretes GUI for bankaccount class
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class BankPanel extends JPanel
	{
	 
		private BankAccount myAcct;
		private String accountStatus;
		private DecimalFormat dfmt;
		
		private JLabel accountNameL;
		private JLabel accountNumberL;  
		private JLabel accountBalanceL;
		private JLabel accountStatusL;
		private JLabel amountLabel;
		
		
		private JTextField accountNameTF;
		private JTextField accountNumberTF;
		private JTextField accountBalanceTF;
		private JTextField accountStatusTF;
		private JTextField amountTF;		
		private JButton depositButton;
		private JButton withdrawButton;

		



	//  Constructor: Sets up the GUI.
	
	public BankPanel ()
	{
	   		
		    myAcct = new BankAccount( 63363, 0.00,"Wyatt Colyn");
	   		dfmt = new DecimalFormat("0.00");
		  
		   
		//create labels
			accountNameL = new JLabel("Account Name");
			accountNumberL = new JLabel("Account Number");  		
			accountBalanceL = new JLabel("Account Balance");
			accountStatusL = new JLabel("Account Status");
			amountLabel = new JLabel("Deposit/Withdraw amount");
			
			
			//create textfields and assign initial values
			accountNameTF = new JTextField(15);
			//accountNameTF.setText(myAcct.getName());
			accountNumberTF = new JTextField(15);
			accountBalanceTF = new JTextField(15);
			accountStatusTF = new JTextField(15);
			amountTF = new JTextField(15);
		
			//set up buttons and register with ActionListener
			depositButton = new JButton("Deposit");
			withdrawButton = new JButton("Withdraw");
			depositButton.addActionListener(new ButtonListener());
			withdrawButton.addActionListener(new ButtonListener());
		     
	        //add components to the panel
			add(accountNameTF);
			add(accountNumberL);
			add(accountNumberTF);
			add(accountBalanceL);
			add(accountBalanceTF);
			add(accountStatusL);
			add(accountStatusTF);
			add(depositButton);
			add(withdrawButton);
			add(amountLabel);
			add(amountTF);
		
			
			setBackground (Color.cyan);
			setPreferredSize (new Dimension(250, 200));
			accountNumberTF.setText(Integer.toString(myAcct.getAcctNumber()));
			accountNameTF.setText(myAcct.getName());
			amountTF.setText( Double.toString(0.0) );
			accountStatusTF.setText("OK");
			accountBalanceTF.setText(dfmt.format(myAcct.getBalance()));
	}

	
	//  Represents a listener for button push (action) events.

	private class ButtonListener implements ActionListener
	{
	   //  Updates the counter and textField when the button is pushed.	  
	   public void actionPerformed (ActionEvent event)
	   {
		   double amount = Double.parseDouble(amountTF.getText());
		   
		   if(event.getSource() == depositButton)
		   {
			   myAcct.deposit(amount);
		   }
						    
			if(event.getSource() == withdrawButton)
			{
				myAcct.withdraw(amount);
			}
					
			if(myAcct.getBalance() >= 0)
			{
				accountStatusTF.setText("OK");
			}
			else
			{
			accountStatusTF.setText("Overdrawn");
		}
			accountBalanceTF.setText(Double.toString(myAcct.getBalance()));
			
				
	   }//end of actionPerformed method
		
	}//end of ButtonListener
		
	}//end of BankPanel
