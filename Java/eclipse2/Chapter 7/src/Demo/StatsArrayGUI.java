package Demo;

/* Program ID:  StatsArrayGUI.java   
   Author:  Patricia Baker and Wyatt Colyn
		
	Brief Description:  
		Statistics Array Assignment GUI
      This is the GUI for the StatsArray class.
      The StatsArray is used to hold 10 grades
   
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StatsArrayGUI extends JFrame
		implements ActionListener {

	//set up buttons to control the StatsArray
	private JButton maxButton;
	private JButton minButton;
	private JButton sumButton;
	private JButton avgButton;
	private JButton aButton;
	private JButton numberButton;
	private JButton sortButton;
	private JButton startOverButton;

	private JPanel panel;

	//instantiate your StatsArray object called grades
	//that contains a 10 element integer array
	private StatsArray grades = new StatsArray( );


	public static void main(String[ ] args) {
	     StatsArrayGUI demo = new StatsArrayGUI( );
		  demo.setTitle("Statistics Array GUI");
	     demo.setSize(400,400);
	     demo.createGUI();
	     demo.setVisible(true);
    }

	private void createGUI() {
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    Container window = getContentPane();
	    window.setLayout(new FlowLayout());

	    panel = new JPanel();
	    panel.setPreferredSize(new Dimension(300, 200));
	    panel.setBackground(Color.white);
       window.add(panel);

		//buttons
		startOverButton = new JButton("New Array");
		window.add(startOverButton);
		startOverButton.addActionListener(this);

		maxButton = new JButton("Maximum");
		window.add(maxButton);
		maxButton.addActionListener(this);

		minButton = new JButton("Minimum");
		window.add(minButton);
		minButton.addActionListener(this);

		sumButton = new JButton("Sum");
		window.add(sumButton);
		sumButton.addActionListener(this);

		avgButton = new JButton("Average");
		window.add(avgButton);
		avgButton.addActionListener(this);

		aButton = new JButton("Number of A's ");
		window.add(aButton);
		aButton.addActionListener(this);


		numberButton = new JButton("Lucky 7?");
		window.add(numberButton);
		numberButton.addActionListener(this);

		sortButton = new JButton("Sort");
		window.add(sortButton);
		sortButton.addActionListener(this);


		/* invokes method to fill array with random numbers
		   between 1 and 100 */
		grades.fillArray();


	}


	//Button and TextField event handler
	public void actionPerformed(ActionEvent event) {
		Graphics g = panel.getGraphics();
		
      Object source = event.getSource();

        /*cover up old display before
		  drawing the new values.  Then
		  set the color back to black
		 */
		 g.setColor(Color.white);
       g.fillRect(0, 0, 300, 200);
       g.setColor(Color.black);

		if (source == minButton)
			g.drawString("Minimum is: " + grades.getMin(), 50, 20); //min value, x, y
		else if (source == maxButton)
			g.drawString("Maximum is: " + grades.getMax(), 50, 20);
		else if (source == sumButton)
			g.drawString("Sum is: " + grades.getSum(), 50, 20);
		else if (source == avgButton)
			g.drawString("Average is: " + grades.getAverage(), 50, 20);
		else if (source == aButton)
			g.drawString("Number of A's = " + grades.countValues(90, 100), 50, 20);
		else if (source == numberButton)
			g.drawString("Lucky 7  Y or N: " +( (grades.isValueFound( 7 )) ?  'Y' : 'N'), 50, 20);
		else if (source == sortButton){
			grades.sortArray();
			g.drawString("Sorted!" , 50, 20);
		}
		else if (source == startOverButton){
			grades.fillArray();
			g.drawString("New Values" , 50, 20);
		}

		grades.display(g);  //lets see the array of random numbers!
	}

}
