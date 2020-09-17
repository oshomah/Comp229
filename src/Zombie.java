import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Zombie {
	private ImageIcon imgZombie, imgDeadZombie;
	private boolean isDead;
	private Random rnd;
	private int xPos, yPos, width, height, direction;
	final int EAST = 0, WEST = 1;
	
	public Zombie(){
		rnd = new Random();
		direction = rnd.nextInt(2);
		String address = "images\\zombie"+rnd.nextInt(6);
		if (direction == WEST){
			address = address+"West.png";
		}else
				address = address+"East.png";
		imgZombie = new ImageIcon(address);
		width = imgZombie.getIconWidth(); 
		height = imgZombie.getIconHeight();
		if(direction==EAST){
			xPos = -width;
		}else{
			xPos = 900+width;
		}
		yPos=rnd.nextInt(665-height-10)+10;
	}
	public void draw(Graphics2D g2){
		if(isDead){
			imgDeadZombie = new ImageIcon("images\\deadZombie.png");
			g2.drawImage(imgDeadZombie.getImage(), xPos, yPos, null);
		}
		else 
			g2.drawImage(imgZombie.getImage(), xPos, yPos, null);
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
    public void setLocation(int x, int y){
    	xPos = x;
    	yPos = y;	
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
    public void shot(){
    	isDead = true;
    }
    public void alive(){
    	isDead = false;
    }
}
