import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex4JPanel extends JPanel  {

    private final String INITIAL_PROMPT = "Please press mouse button to start...";
    
    /* To store the text typed by the user */
    private String text;
    
    public Ex4JPanel() {
        setBackground(Color.WHITE);
        
        // Initialise the String to INITIAL_PROMPT
        
        //  Add the listeners
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the String
        
    }
    
    public void keyPressed(KeyEvent e) {
        // get the key and add it to the String
        
    }
    
    public void mousePressed(MouseEvent e) {
        // clear the text from the screen.
        
    }
    
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}
