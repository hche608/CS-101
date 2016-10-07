/**
  * The JPanel class for the floating balloon
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex1JPanel extends JPanel implements ActionListener {
    
    private Face balloon;
    private JButton moveButton;
    
    public Ex1JPanel() {
        
        
        balloon = new Face(30,60);                  // Construct the balloon
        
        
        moveButton = new JButton("Move balloon");   // Set up the button
        moveButton.addActionListener(this);
        add(moveButton);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        balloon.move();
        
        requestFocusInWindow();
        
        repaint();
    }
    
    public void keyPressed(KeyEvent e) {
        // Update the direction of the balloon by calling the setDirection() method on balloon.
        // The direction (either Face.LEFT, Face.RIGHT, Face.UP or Fish.DOWN) that you pass      
        // to the setDirection() method will depend on what key the user has pressed.
        
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        balloon.draw(g);
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}

