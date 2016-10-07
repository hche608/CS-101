import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex4JPanel extends JPanel implements MouseListener, ActionListener /* What do you need here? */  {
    
    private Fish[] movingFish;
    private int numberOfFish;
    private Timer t;
    
    public Ex4JPanel() {
        setBackground(Color.CYAN);
        
        // Construct the movingFish array big enough to hold 30 fish.
        movingFish = new Fish[30];
        // Initialise numberOfFish to 0
        numberOfFish = 0;
        // Add the MouseListener
        addMouseListener(this);
        // Construct the Timer and start it ticking
        t = new Timer(150,this);
        t.start();
    }
    
    public void mousePressed(MouseEvent e) {
        
        // if the movingFish array is not already full (i.e. numberOfFish < movingFish.length):
        //    get the Point where the user pressed the mouse,
        //    construct a Fish at the point where mouse was pressed
        //    store in the next available position in the movingFish array
        //     (the index of the next available position is given by numberOfFish)
        //    increase numberOfFish by 1.
        Point p = e.getPoint();
        if (numberOfFish < movingFish.length){
            movingFish[numberOfFish] = new Fish(p);
            numberOfFish++;
        }
        //repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Insert a for loop here to loop through the movingFish array
        //   drawing each fish by calling the draw(g) method on movingFish[i]
        for (int i = 0; i < numberOfFish; i++){
            if (movingFish[i] != null){
                movingFish[i].draw(g);
            }
        }
        // Remember that not all the elements in the movingFish array may
        // contain a Fish.  Use numberOfFish in your loop condition.
        
    }
    public void actionPerformed(ActionEvent e) {
        // Insert a for loop here to loop through the movingFish array
        //    moving each fish by calling the move() method on movingFish[i]
        for (int i = 0; i < numberOfFish; i++){
            movingFish[i].move();          
        }
        repaint();
    }
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    
}
