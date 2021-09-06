package Pongsimple;
import java.awt.Color;
import java.awt.Graphics;

public class Player2Paddle {

	private int y = (PongS.WINDOW_HEIGHT / 2) - 30;
	private int yVelocity = 0;
	private int width = 10;
	private int height = 50;			

	public Player2Paddle() {
	}

	public void update() {
		y = y + yVelocity;
	}

	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(1000 - 45, y, width, height);
	}

	public void setYVelocity(int speed) {
		yVelocity = speed;
	}

	public int getX() {
		return (1000 - 45 - width);
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