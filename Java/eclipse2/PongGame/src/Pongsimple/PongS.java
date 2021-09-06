package Pongsimple;

import javax.swing.JFrame;

public class PongS extends JFrame {

	final static int WINDOW_WIDTH = 1000;
	final static int WINDOW_HEIGHT = 500;

	public PongS() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new PongPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		new PongS();
	}
}