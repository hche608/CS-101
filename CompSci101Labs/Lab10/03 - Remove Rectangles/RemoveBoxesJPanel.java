import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/* What do you need to add here? */

public class RemoveBoxesJPanel extends JPanel implements MouseListener/* What do you need to add here? */ {
    
    private Rectangle[] boxes;
    private int totalNumberOfClicks;
    
    public RemoveBoxesJPanel() {
        setBackground(Color.PINK);
        totalNumberOfClicks = 0;
        
        createBoxesArray();  // Construct and initialise the boxes array (already done for you)
        
        // What do you need to add here to listen out for MouseEvents?
        addMouseListener(this);
    }
    
    public void createBoxesArray() {
        boxes = new Rectangle[30];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = createRandomRectangle();
        }
    }
    
    private Rectangle createRandomRectangle() {
        int x = (int)(Math.random()*300);
        int y = (int)(Math.random()*300);
        int width = (int)(Math.random()*(370 - x)) + 20;
        int height = (int)(Math.random()*(350 - y)) + 20;
        return new Rectangle(x, y, width, height);
    }
    
    public void mousePressed(MouseEvent e) {
        totalNumberOfClicks++;
        
        // get the Point where the user clicked
        Point p = e.getPoint();
        
        // then loop through the boxes array checking
        // each Rectangle to determine whether the user has clicked inside   
        for (int i = 0; i < boxes.length; i++){
            if (boxes[i] != null && boxes[i].contains(p)){
                boxes[i] = null;
            }
        }
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Courier", Font.BOLD, 24));
        g.drawString("Total clicks: " + totalNumberOfClicks, 0,400);
        
        // Insert a for loop to loop through the boxes array
        // and draw each Rectangle in the array.
        for (int i = 0; i < boxes.length; i++){
            if (boxes[i] != null){
                g.drawRect(boxes[i].x,boxes[i].y,boxes[i].width,boxes[i].height);
            }        
            
        }
    }
    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}    
}

