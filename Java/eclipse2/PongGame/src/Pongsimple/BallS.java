package Pongsimple;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BallS {

	private int xPosition = (PongS.WINDOW_WIDTH / 2);
	private int yPosition = (PongS.WINDOW_HEIGHT / 2);
	private int xVelocity = -5;
	private int yVelocity = 5;
	private int size = 10;
	private int playerScore = 0;
	private int player2Score = 0;

	public void update() {
		xPosition = xPosition + xVelocity;
		yPosition = yPosition + yVelocity;

		if (xPosition < 0) {
			player2Score = player2Score + 1;
			xPosition = PongS.WINDOW_WIDTH / 2;
			yPosition = PongS.WINDOW_HEIGHT / 2;
			reverseDirection();

		} else if (xPosition + size > PongS.WINDOW_WIDTH) {
			playerScore = playerScore + 1;
			xPosition = PongS.WINDOW_WIDTH / 2;
			yPosition = PongS.WINDOW_HEIGHT / 2;
			reverseDirection();
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(xPosition, yPosition, size, size);
		g.drawString(toPlayer(), 5, 15);
		g.drawString(toPlayer2(), 900, 15);
	}

	private void reverseDirection() {
		xVelocity = -xVelocity;
	}

	private void reverseDirectionY() {
		yVelocity = -yVelocity;
	}

	public void checkCollisionWith(PlayerPaddle player) {
		if (this.xPosition > player.getX() && this.xPosition < player.getX() + player.getWidth()) {
			if (this.yPosition > player.getY() && this.yPosition < player.getY() + player.getHeight()) {
				reverseDirection();
			}
		}
	}

	// public void checkCollisionWith(AIPaddle ai) {
	// if (this.xPosition > ai.getX() && this.xPosition < ai.getX() + ai.getWidth())
	// {
	// if (this.yPosition > ai.getY() && this.yPosition < ai.getY() +
	// ai.getHeight()) {
	// reverseDirection();
	// }
	// }

	public void checkCollisionWith(Player2Paddle player2) {
		if (this.xPosition > player2.getX() && this.xPosition < player2.getX() + player2.getWidth()) {
			if (this.yPosition > player2.getY() && this.yPosition < player2.getY() + player2.getHeight()) {
				reverseDirection();
			}
		}
	}

	public void hitWall() {
		if (this.yPosition < 30 + size) {
			reverseDirectionY();
		} else if (this.yPosition > 450 - size) {
			reverseDirectionY();
		}
	}

	public int getX() {
		return xPosition;
	}

	public int getY() {
		return yPosition;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public int getPlayer2Score() {
		return player2Score;
	}

	public String PlayerWin() {
		String win = "Morty! Morty! I win!";
		return win;
	}

	public String Player2Win() {
		String win = "I win Rick!";
		return win;
	}

	public void Stop() {
		xVelocity = 0;
		yVelocity = 0;
		xPosition = PongS.WINDOW_WIDTH / 2;
		yPosition = PongS.WINDOW_HEIGHT / 2;
	}

	public String toPlayer() {
		String score = "";
		score = "Rick Score: " + playerScore;
		return score;
	}

	public String toPlayer2() {
		String score = "";
		score = "Morty Score: " + player2Score;
		return score;
	}
}