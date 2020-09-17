import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
	private ImageIcon imgEast, imgWest, imgDead, imgPlayer;
	private boolean isDead;
	private int xPos, yPos, width, height, direction;
	public static final int EAST = 1, WEST = 0;

	public Player() {
		imgEast = new ImageIcon("images//shooterEast.png");
		imgWest = new ImageIcon("images//shooterWest.png");
		imgPlayer = imgEast;
		width = imgPlayer.getIconWidth();
		height = imgPlayer.getIconHeight();
		xPos = 50;
		yPos = 50;
	}

	public Player(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public Player(int x, int y, int dir) {
		direction = dir;
	}

	public void draw(Graphics2D g2) {
		if (isDead) {
			imgDead = new ImageIcon("images\\deadPlayer.png");
			g2.drawImage(imgDead.getImage(), xPos, yPos, null);
		} else{
			if (direction == WEST) {
				imgPlayer = imgWest;
			} else {
				imgPlayer = imgEast;
			}
			g2.drawImage(imgPlayer.getImage(), xPos, yPos, null);
		}
	}

	public int getDirection() {
		return direction;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public void move(int x) {
		xPos = x;
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	public void setX(int x) {
		xPos = x;
	}

	public void setY(int y) {
		yPos = y;
	}
	
	public Rectangle getRect(){
		return new Rectangle(xPos, yPos, width, height-20);
	}

	public void setLocation(int x, int y){
    	xPos = x;
    	yPos = y;	
    }

	public void killPlayer() {
		isDead = true;
	}
	public void isalive(){
		isDead = false;
	}
}