/*
 * Purpose: to define a single Blob object.
 * 
 * Author: CompSci 101

 */

import java.awt.*;

public class Blob {
    public static final int BLOB_SIZE = Ex5JPanel.BLOB_SIZE; 
    public static final Point CENTRE_POINT = Ex5JPanel.CENTRE_POINT;  
    
    public static final Rectangle GAME_AREA = Ex5JPanel.GAME_AREA; 
    public static final Rectangle LEFT_OF_GAME_AREA = Ex5JPanel.LEFT_OF_GAME_AREA;
    public static final Rectangle RIGHT_OF_GAME_AREA = Ex5JPanel.RIGHT_OF_GAME_AREA;
    
    
    private int moveX;
    private Rectangle area;
    private boolean isVisible;
    
    public Blob() {
        int range = BLOB_SIZE / 2;
        
        moveX = (int) (Math.random() * range  + 4);
        if (Math.random() < 0.5) {
            moveX = -moveX;
        }
        
        int y = (int) (Math.random() * (GAME_AREA.height - BLOB_SIZE) +  GAME_AREA.y);
        area = new Rectangle(CENTRE_POINT.x - BLOB_SIZE / 2, y, BLOB_SIZE, BLOB_SIZE); 
        
        isVisible = true;
    }
     
    public boolean getIsVisible() {
        
    }

    public void move() {
            
    }

    public void draw(Graphics g) {
        if (! isVisible) {
            return;
        }
        
    }
}


