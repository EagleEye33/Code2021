package activity1;

import javax.swing.JFrame;

public class CatchTheCreature {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Catch the Creature!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1000, 1000);
		
		CreaturePanel PanelFinal = new CreaturePanel();
		frame.getContentPane().add(PanelFinal);	
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
