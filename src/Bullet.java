import java.awt.*;

import javax.swing.ImageIcon;


public class Bullet {
	private ImageIcon imgEast, imgWest;
	private boolean isFired;
	private int xPos, yPos, width, height, direction;
	public static final int EAST = 1, WEST = 0;
	
	public Bullet(){
		imgEast = new ImageIcon("images//bulletEast.png");
		imgWest = new ImageIcon("images//bulletWest.png");
		width = imgEast.getIconWidth();
		height = imgEast.getIconHeight();
	}
	public Bullet(int x, int y){
		xPos = x;
		yPos = y;
	}
	public void draw(Graphics2D g2){
		if (direction == WEST) {
			g2.drawImage(imgWest.getImage(), xPos, yPos, null);
		} else {
			g2.drawImage(imgEast.getImage(), xPos, yPos, null);
		}
		
	}
	public int getDirection(){
		return direction;
		
	}
	public int getHeight(){
		return height;
		
	}
	public int getWidth(){
		return width;
		
	}
	public int getX(){
		return xPos;
		
	}
	public int getY(){
		return yPos;
		
	}
	public void move(){
		if (direction == EAST)
    		xPos++;
    	else
    		xPos--;
	}
	public void move(int x){
		xPos = x;
	}
	public void setDirection(int dir){
		direction = dir;
	}
	public void setPosition(int playerX, int playerY, int dir){
		xPos = playerX; 
		yPos = playerY;
		direction = dir;
	}
	public void setX(int x){
		xPos = x;
	}
	public void setY(int y){
		yPos = y;
	}
	 public Rectangle getRect(){
			return new Rectangle(xPos, yPos, width, height);
		}
	 public void isFired(){
		isFired = true;
		 
	 }

}
