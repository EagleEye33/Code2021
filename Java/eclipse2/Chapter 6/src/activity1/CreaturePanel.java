package activity1;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;

public class CreaturePanel extends JPanel {
	
	Random CreatureGenerator = new Random();
	
private final int WINDOW_WIDTH = 1000;
private final int WINDOW_LENGTH = 1000;
private Point point = null;
private int creaturecounter;
private final int creatureSize = 15;
private int creatureXPosition = 500;
private int creatureYPosition = 500;
private JLabel CreatureLabel;
private JTextField CreatureText;
private Timer timer;

		public CreaturePanel () {
			
			   setBackground(Color.cyan);
			   
		CreatureLabel = new JLabel("Number of times Creature Caught: ");
		CreatureText = new JTextField(10);
		add(CreatureLabel);
		add(CreatureText);
		
		addMouseListener(new CreatureMouseListener());
		
		timer = new Timer(1000, new CreatureListener());
		
		this.setFocusable(true);
		
		timer.start();
		}
	

	 public void paintComponent(Graphics page)
	 {
		 super.paintComponent(page);
		 page.setColor(Color.red);
		 page.fillOval(getCreatureXPosition(), getCreatureYPosition(), creatureSize, creatureSize);
	 }
	 
	
	public int getCreatureYPosition() {
		return creatureYPosition;
	}


	public void setCreatureYPosition(int creatureYPosition) {
		this.creatureYPosition = creatureYPosition;
	}


	public int getCreatureXPosition() {
		return creatureXPosition;
	}


	public void setCreatureXPosition(int creatureXPosition) {
		this.creatureXPosition = creatureXPosition;
	}

	private class CreatureMouseListener implements MouseListener {
		
		public void mousePressed (MouseEvent event)
		{
			if (event.getX() >= getCreatureXPosition() &&
			         event.getX() < getCreatureXPosition() + creatureSize &&
			         event.getY() >= getCreatureYPosition() &&
			         event.getY() < getCreatureYPosition() + creatureSize)
			{
				creaturecounter+=1;
				CreatureText.setText(Integer.toString(creaturecounter));
				repaint();
			}
		}
	
		 
		 
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}


	}
	private class CreatureListener implements ActionListener
	{
		
		
				
	public void actionPerformed(ActionEvent event)
	{
		setCreatureXPosition(CreatureGenerator.nextInt(WINDOW_WIDTH));
		setCreatureYPosition(CreatureGenerator.nextInt(WINDOW_LENGTH));
		
		repaint();
	}

	}
	

	
	
	}

		
	
	
	
	
