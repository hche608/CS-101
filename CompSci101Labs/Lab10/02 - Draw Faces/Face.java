/**
  * A class representing a Face
*/
import java.awt.*;

public class Face {
    
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    
    // Top left hand corner of Face
    private int x;
    private int y;
    private int size;
    private int speed;
    
    // This variable stores the current direction of the face
    private int direction;
    private Color faceColour;
    
    public Face(Point position) {
        int red = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        faceColour = new Color(red, green, blue);
        size = (int)(Math.random() * 8 + 1);
        x = position.x - (size*8) / 2;
        y = position.y - (size*9) / 2;
    }
     
    // Draw the face
    public void draw(Graphics g) {        
        g.setColor(faceColour);
        g.fillOval(x, y, 8 * size, 9 * size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 8 * size, 9 * size);
        g.setColor(Color.BLUE);
        g.fillOval(x + 2*size, y + 2*size, size, size);
        g.fillOval(x + 5*size, y + 2*size, size, size);
        g.setColor(Color.WHITE);
        g.fillOval(x + 2*size, y + 5*size,4*size, 2*size);     
    }
    
    public boolean contains(Point p) {
        Rectangle rect = new Rectangle(x, y, 8 * size, 9 * size);
        return rect.contains(p);
    }
}

