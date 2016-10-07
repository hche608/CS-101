import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ConnectLinesJPanel extends JPanel implements MouseListener{

    private Point[] clicks;
    private int numberOfClicks;
    
    public ConnectLinesJPanel() {
        setBackground(Color.white);
        
        // Construct the clicks array
        
        // Initialise numberOfClicks to 0
        
        // Add the MouseListener
        
    }
    
    public void mousePressed(MouseEvent e) {
        // If the clicks array is not already full,
        //   get the Point where the user pressed the mouse
         
        //   store the Point in the next available postion in the clicks array
        //   and increase numberOfClicks by 1.
  
    }
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Insert a for loop here to loop through the clicks array
        //   (Starting with element 1)
        //   and draw a line connecting each Point to the previous Point,
        //   i.e. draw a line between clicks[i] and clicks[i-1].
        //   Remember that not all the elements in the clicks array may
        //   contain a Point.  Use numberOfClicks in your loop condition.
        
        
    }
}
