import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class MouseEventDemo extends JPanel implements MouseMotionListener{
   private ImageIcon pic;
   private int x = 20, y = 20;
   
 public static void main(String[] args) {
  new MouseEventDemo();
 }
 
 public MouseEventDemo(){
  pic = new ImageIcon("images//zombie0East.png");
  //set up JPanel
  setLayout(null);
  addMouseMotionListener(this);
  
  //set up frame
  JFrame frame = new JFrame();
  frame.setSize(600, 600);
  frame.setTitle("MouseEvent Demo");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLocationRelativeTo(null);
  frame.setContentPane(this);
  frame.setVisible(true);
 }
 public void mouseDragged(MouseEvent e){
 x = e.getX();
 y = e.getY();
 repaint ();
 }
 public void mouseMoved(MouseEvent e){}
 
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D) g;
  g2.drawImage(pic.getImage(), x, y, null);
    
 }

}
