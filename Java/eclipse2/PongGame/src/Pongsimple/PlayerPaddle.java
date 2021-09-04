package Pongsimple;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerPaddle {

	private int y = (PongS.WINDOW_HEIGHT / 2) - 30;
	private int yVelocity = 0;
	private int width = 10;
	private int height = 50;

	public PlayerPaddle() {
	}

	public void update() {
		y = y + yVelocity;
	}

	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(getX(), y, width, height);
	}

	public void setYVelocity(int speed) {
		yVelocity = speed;
	}

	public int getX() {
		return 15;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}	
}
