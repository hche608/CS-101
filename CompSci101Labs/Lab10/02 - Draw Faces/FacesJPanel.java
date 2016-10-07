import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FacesJPanel extends JPanel /* What do you need here? */   {

    private Face[] faces;
    private int numberOfFaces;
    
    public FacesJPanel() {
        setBackground(Color.white);
        
        // Construct the faces array
        
        // Initialise numberOfFaces to 0
        
        // Add the MouseListener
        
    }
    
    public void mousePressed(MouseEvent e) {
        
        // If the faces array is not already full,
        //  get the Point where the user pressed the mouse,
        // construct a Face at the point clicked and
        // store in the next available position in the array.
        //  increase numberOfFaces by 1.
        
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Insert a for loop here to loop through the faces array
        //   drawing each face by calling the draw() method in the Face class.
        
        // Remember that not all the elements in the faces array may
        // contain a Face.  Use numberOfFaces in your loop condition.
        
    }
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
 
}
