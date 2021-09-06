package activity1;

//********************************************************************
//  Program Name:BankGUI.java      
//  Author :  P Baker 
  
//
//  Brief Description: Creates a simple GUI for the BankAccount Class
//********************************************************************

import javax.swing.JFrame;

public class BankGUI
{
   //-----------------------------------------------------------------
   //  Creates and displays the main program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("My Bank Account");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      BankPanel panel = new BankPanel();
      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);
   }
}