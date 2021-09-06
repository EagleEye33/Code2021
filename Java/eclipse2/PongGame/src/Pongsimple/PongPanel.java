package Pongsimple;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {

	PlayerPaddle player = new PlayerPaddle();
	BallS ball = new BallS();
	// AIPaddle ai = new AIPaddle(this);
	Player2Paddle player2 = new Player2Paddle();

	public PongPanel() {
		Timer time = new Timer(10, this);
		time.start();

		this.addKeyListener(this);
		this.setFocusable(true);
	}

	private void update() {
		ball.checkCollisionWith(player);
		// ball.checkCollisionWith(ai);
		ball.checkCollisionWith(player2);
		ball.hitWall();
		
		player.update();
		ball.update();
		// ai.update();
		player2.update();


	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, PongS.WINDOW_WIDTH, PongS.WINDOW_HEIGHT);

		player.paint(g);
		ball.paint(g);
		// ai.paint(g);
		player2.paint(g);

		g.setColor(Color.blue);
		g.drawLine(0, 30, PongS.WINDOW_WIDTH, 30);
		g.drawLine(PongS.WINDOW_WIDTH / 2, 30, PongS.WINDOW_WIDTH / 2, PongS.WINDOW_HEIGHT);
		g.drawOval((PongS.WINDOW_WIDTH / 2) - 30, PongS.WINDOW_HEIGHT / 2 - 30, 60, 60);
		g.setColor(Color.yellow);

		if (ball.getPlayer2Score() >= 10 || ball.getPlayerScore() >= 10) {
			Font font = new Font("Lucida Sans Unicode", Font.PLAIN, 26);
			ball.Stop();
			if (ball.getPlayerScore() == 10) {
				g.setFont(font);
				g.drawString(ball.PlayerWin(), (PongS.WINDOW_WIDTH / 2) - 120, PongS.WINDOW_HEIGHT / 3);
			}
			if (ball.getPlayer2Score() == 10) {
				g.setFont(font);
				g.drawString(ball.Player2Win(), (PongS.WINDOW_WIDTH / 2) - 60, PongS.WINDOW_HEIGHT / 3);
			}
		}
	}


	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.setYVelocity(-6);

			if (player.getY() < 30) {
				player.setYVelocity(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.setYVelocity(6);
			if (player.getY() + player.getHeight() > PongS.WINDOW_HEIGHT - 45) {
				player.setYVelocity(0);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player2.setYVelocity(-6);

			if (player2.getY() < 30) {
				player2.setYVelocity(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			player2.setYVelocity(6);
			if (player2.getY() + player2.getHeight() > PongS.WINDOW_HEIGHT - 45) {
				player2.setYVelocity(0);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
			player.setYVelocity(0);
		}
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S) {
			player2.setYVelocity(0);
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}