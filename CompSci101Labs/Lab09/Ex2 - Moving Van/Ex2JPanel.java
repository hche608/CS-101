/**
  * The JPanel class for the icecream van, mrWhippy.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex2JPanel extends JPanel implements ActionListener, KeyListener,MouseListener/* ----- What do you need to put here? */  {

    private Van mrWhippy;
    private Timer t;
    
    
    public Ex2JPanel() {
        
        mrWhippy = new Van(30,30, "Mr Whippy");  // Construct the Van
        t = new Timer(30, this);
        addMouseListener(this);
        addKeyListener(this);
        // Add the MouseListener and the Timer (set Timer to tick every 30 milliseconds)
        // Add the KeyListener
        
    }
    
    public void actionPerformed(ActionEvent e) {
        // Move the van by calling the move() method on mrWhippy
        mrWhippy.move();
        repaint();
    }
    
    public void mousePressed(MouseEvent e) {
        t.start();
        // Start the Timer ticking as soon as the mouse is pressed.
    }
    
    public void keyPressed(KeyEvent e) {
        
        // Change direction (by calling the setDirection() method on mrWhippy)
        //    if the LEFT or RIGHT arrow key is pressed.
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            mrWhippy.setDirection(Van.LEFT);
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            mrWhippy.setDirection(Van.RIGHT);
        }
        // Speed up if the UP arrow key is pressed
        
        // Slow down if the DOWN arrow key is pressed.
        else if (e.getKeyCode()==KeyEvent.VK_UP){
            mrWhippy.speedUp();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            mrWhippy.slowDown();
        }
        // Change colour if the 'c' key is pressed.
        else if (e.getKeyChar()=='c'){
            mrWhippy.changeColour();
        }
        // Stop if the 's' key is pressed.
        else if (e.getKeyChar()=='s'){
            t.stop();
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        mrWhippy.draw(g);
        g.setFont(new Font("Times New Roman", 0, 24));
        g.drawString("Press mouse to start van moving", 100, 170);
        g.drawString("Left Arrow to go left", 100, 200);
        g.drawString("Right Arrow to go right", 100, 230);
        g.drawString("Up Arrow to increase speed", 100, 260);
        g.drawString("Down Arrow to decrease speed", 100, 290);
        g.drawString("c to change colour", 100, 320);
        g.drawString("s to stop", 100, 350);
        
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}

