import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ZombieGame extends JPanel implements MouseListener,
		ActionListener, MouseMotionListener, KeyListener {

	private ImageIcon imgBackground;
	private Zombie[] z;
	private Player s;
	private Timer t, t2, b2;
	private int spawn, time, time2, btime, score;
	private boolean dead = false, shot, respawn = false;
	private Bullet b;

	public static void main(String[] args) {

		new ZombieGame();
	}

	public ZombieGame() {
		b = new Bullet();

		imgBackground = new ImageIcon("images\\zombie_game_background.png");

		// initialize timer object
		t = new Timer(10, this);
		t2 = new Timer(1010, this);
		b2 = new Timer(1, this);
		time = 0;
		time2 = 0;
		btime = 0;
		z = new Zombie[10];
		for (int i = 0; i < z.length; i++) {
			z[i] = new Zombie();
		}
		
		// Player
		s = new Player();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);

		// set JPanel properties
		setLayout(null);
		setFocusable(true);

		JFrame frame = new JFrame();
		frame.setContentPane(this);
		frame.setSize(imgBackground.getIconWidth(),
				imgBackground.getIconHeight());
		frame.setLocationRelativeTo(null);
		frame.setTitle("Zombie Attack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

		t.start();
		t2.start();
		b2.start();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(imgBackground.getImage(), 0, 0, this);
		for (int i = 0; i < z.length; i++) {
			z[i].draw(g2);
		}
		if (shot == true) {
			b.draw(g2);
		}

		s.draw(g2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			btime++;
			if (shot) {
				b.move();
				repaint();
			}
			if (s.getDirection() == Player.EAST) {
				b.setDirection(Player.EAST);
			} else {
				b.setDirection(Player.WEST);
			}
		}
		if (e.getSource() == t2) {
			time2++;

			if (time2 % 2 == 0 && dead == true) {
				s = new Player();
				JOptionPane.showMessageDialog(
						null,
						"Your score is "+ score, "Zombie game",
						JOptionPane.INFORMATION_MESSAGE);
				t.start();
				dead = false;
				score = 0;
				for (int i = 0; i < z.length; i++) {
					z[i] = new Zombie();
				}
			}
		

		}
		if (e.getSource() == t) {
			time++;

			if (time % ((spawn + 1) * 100) == 0 && spawn < z.length) {
				z[spawn] = new Zombie();
				spawn++;
			}

			for (int i = 0; i < spawn; i++) {
				if ((z[i].getDirection() == z[i].EAST && z[i].getX() == 900)
						|| (z[i].getX() == 0 - z[i].getWidth() && z[i]
								.getDirection() == z[i].WEST)) {
					z[i] = new Zombie();
				}
				z[i].move();
				repaint();
				checkCollision();
				dead();

			}
		}

	}

	private void dead() {
		for (int i = 0; i < z.length; i++) {
			if (z[i].getRect().intersects(b.getRect())) {
				z[i].shot();
				b.setY(2000); 
					z[i] = new Zombie();
					score++;
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			s.setDirection(Player.WEST);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			s.setDirection(Player.EAST);
		}
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		s.setLocation(e.getX() - s.getWidth() / 2, e.getY() - s.getHeight() / 2);
		repaint();
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	public void checkCollision() {

		for (int i = 0; i < z.length; i++) {
			if (z[i].getRect().intersects(s.getRect())) {
				dead = true;
				s.killPlayer();
				repaint();
				t.stop();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			shot = true;
			b.setX(s.getX());
			b.setY(s.getY() + 50);
		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
