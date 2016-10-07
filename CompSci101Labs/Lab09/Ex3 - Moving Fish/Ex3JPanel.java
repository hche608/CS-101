/**
  * The JPanel class for the moving fish
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex3JPanel extends JPanel // what do you need to insert here?  {

    private Fish freddy;
    private Timer t;
    
    public Ex3JPanel() {
        setBackground(Color.CYAN);
        freddy = new Fish(50,80,70, 4);  
        
    }
    
    public void keyPressed(KeyEvent e) {
        // insert code to action the keys being pressed by the user
        
    }
    
    public void actionPerformed(ActionEvent e) {
        // insert code to call the move() method and repaint()
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        freddy.draw(g);
        
        g.setFont(new Font("Times New Roman", 0, 24));
        g.drawString("Left Arrow to go left", 100, 200);
        g.drawString("Right Arrow to go right", 100, 230);
        g.drawString("Up Arrow to increase speed", 100, 260);
        g.drawString("Down Arrow to decrease speed", 100, 290);
        g.drawString("s to stop", 100, 320);
        
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}

