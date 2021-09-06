package activity1;


import java.awt.Component;

//********************************************************************
//Chapter 6 Activity 4 - Die Class GUI Solution
//Program Name:DieGUI.java      
//Author :  P Baker 

//
//Brief Description: Creates a simple GUI for the Die Class
//********************************************************************

import javax.swing.JFrame;

public class dieGUI
{
//-----------------------------------------------------------------
//  Creates and displays the main program frame.
//-----------------------------------------------------------------
public static void main (String[] args)
{
  JFrame frame = new JFrame ("My Die Game ");
  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

  DiePanel panel = new DiePanel();
  frame.getContentPane().add(panel);

  frame.pack();
  frame.setVisible(true);
}
}
