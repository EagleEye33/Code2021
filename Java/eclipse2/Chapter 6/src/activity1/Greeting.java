
//********************************************************************
//  Program Name:Greeting.java    
//  Author :  P Baker 
//  Date :  
//
//  Brief Description: Demonstrates a graphical user interface 
//                     and an event listener. Asks user for name 
//                     and when the user presses the button, 
//                     writes a nice greeting.
//*******************************************************************

package activity1;
import javax.swing.JFrame;

public class Greeting
{
   public static void main(String[] args)
   {
 		//Create frame and panel
      JFrame frame = new JFrame("Greeting");
      GreetingPanel panel = new GreetingPanel();

		//set frame behavior
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//place panel in frame
      frame.getContentPane().add(panel);
		
		//format frame and make available/visible
      frame.pack();
      frame.setVisible(true);
   }
}
