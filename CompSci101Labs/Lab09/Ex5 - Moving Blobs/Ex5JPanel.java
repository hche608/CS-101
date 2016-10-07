/*
 * Purpose: creates moving Blob objects.
 * 
 * Author: CompSci 101

 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex5JPanel extends JPanel implements ActionListener, MouseListener {
    public static final int BLOB_SIZE = 40; 
    public static final int MAX_NUMBER_OF_BLOBS = 30;
    
    public static final int GAP_LEFT_RIGHT = BLOB_SIZE;
    public static final int GAP_ABOVE = 100;
    public static final int GAP_BELOW = 100;
    
    public static final int GAME_AREA_HEIGHT = 400;
    public static final int GAME_AREA_WIDTH = 600;
    public static final Rectangle GAME_AREA = new Rectangle(GAP_LEFT_RIGHT, GAP_ABOVE, GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
    public static final Point CENTRE_POINT = new Point((GAME_AREA.x + GAME_AREA.width / 2), ((GAME_AREA.y + GAME_AREA.height / 2))); 
    
    public static final int JFRAME_AREA_WIDTH = GAME_AREA_WIDTH + 2 * GAP_LEFT_RIGHT;
    public static final int JFRAME_AREA_HEIGHT = GAME_AREA_HEIGHT + GAP_ABOVE + GAP_BELOW;
    
    public static final int LAUNCH_PAD_SIZE = BLOB_SIZE * 2;
    public static final Rectangle LAUNCH_PAD_AREA = new Rectangle(CENTRE_POINT.x - LAUNCH_PAD_SIZE / 2, GAME_AREA.y, LAUNCH_PAD_SIZE + 1, GAME_AREA.height);
    
    public static final Color BACKGROUND_COLOUR = Color.GREEN;
    public static final Color LAUNCH_PAD_COLOUR = Color.GREEN;
    public static final Color GAME_AREA_COLOUR = Color.BLUE;
    
    public static final Rectangle LEFT_OF_GAME_AREA = new Rectangle(-BLOB_SIZE * 2, 0, GAME_AREA.x + BLOB_SIZE * 2, JFRAME_AREA_HEIGHT);
    public static final Rectangle RIGHT_OF_GAME_AREA = new Rectangle(GAME_AREA.x + GAME_AREA.width + 1, 0, JFRAME_AREA_WIDTH - GAME_AREA.x - GAME_AREA_WIDTH + BLOB_SIZE * 2, JFRAME_AREA_HEIGHT);
    
    
    
    private boolean noMoreBlobs;
    private int upTo;
    private Blob[] blobs;
    
    public Ex5JPanel() {
        setBackground(BACKGROUND_COLOUR);
        addMouseListener(this);
        
        initialise();
    }
//-------------------------------------------------------
// Initialise everything
//-------------------------------------------------------
    private void initialise() {
        blobs = new Blob[MAX_NUMBER_OF_BLOBS];
        noMoreBlobs = false;
        upTo = 0;
    }
//-----------------------------------------------------------
// Handle ActionEvents (Comes here each time the Timer ticks)
//-----------------------------------------------------------
   
    public void actionPerformed(ActionEvent e) {  
        if (Math.random() < 0.08) {
            addABlob();
        }       
        moveBlobs();       
        if (moreBlobsToGo() == false) {
            noMoreBlobs = true;
            t.stop();
        }       
        repaint();
    }
//--------------------------------------------------------------------------
// Checks whether there are any blobs either moving or about to start moving
//--------------------------------------------------------------------------
  
    private boolean moreBlobsToGo() { 
        if (noMoreBlobs) {
            return false;
        }       
        if (upTo < MAX_NUMBER_OF_BLOBS) {
            return true;
        }       
        for(int i = 0; i < upTo; i++) {
            if (blobs[i].getIsVisible() == true) {
                return true;
            }
        }       
        return false;
    }
    
//-------------------------------------------------------
// Complete these 3 helper methods
//-------------------------------------------------------
    
    private void moveBlobs() {
        
    }
    
    private void addABlob() {
        
    }
    
    private void drawBlobs(Graphics g) {   
        
    }

//-------------------------------------------------------
// Draw everything
//-------------------------------------------------------
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawInformation(g);
        drawGameArea(g);
        
        drawBlobs(g);  
        
        drawBorderAreas(g);
        
        drawLaunchArea(g);
        
        if (noMoreBlobs) {
            drawEndMessage(g);
        }  
    }
//-------------------------------------------------------
// Drawing helper methods
//-------------------------------------------------------
    private void drawGameArea(Graphics g) {  
        g.setColor(GAME_AREA_COLOUR);
        g.fillRect(GAME_AREA.x, GAME_AREA.y, GAME_AREA.width, GAME_AREA.height);
    }
    
    private void drawLaunchArea(Graphics g) {  
        g.setColor(BACKGROUND_COLOUR);
        g.fillRect(LAUNCH_PAD_AREA.x, LAUNCH_PAD_AREA.y, LAUNCH_PAD_AREA.width, LAUNCH_PAD_AREA.height);  
    }
    
    private void drawInformation(Graphics g) {
        final int HUGE_FONT_SIZE = 60;
        final Font HUGE_FONT = new Font("SansSerif", Font.BOLD, HUGE_FONT_SIZE);
        final Color NICE_GRAY_COLOUR = new Color(157, 161, 158);
        
        int numberOfBlobsToGo = getNumberOfBlobsToGo();
        int xPos = GAME_AREA.x;
        int yPos = GAME_AREA.y - 30;
        
        
        g.setColor(NICE_GRAY_COLOUR);
        g.setFont(HUGE_FONT);
        
        g.drawString("BLOBS TO GO: " + numberOfBlobsToGo, xPos, yPos); 
    }
    
    private int getNumberOfBlobsToGo() {
        int countActive = 0;
        
        for(int i = 0; i < upTo; i++) {
            if (blobs[i].getIsVisible()) {
                countActive++;
            }
        }
        
        return countActive + (MAX_NUMBER_OF_BLOBS - upTo);
    }
    
    private void drawEndMessage(Graphics g) {
        final int HUGE_FONT_SIZE = 60;
        final Font HUGE_FONT = new Font("SansSerif", Font.BOLD, HUGE_FONT_SIZE);
        final Color NICE_GRAY_COLOUR = new Color(157, 161, 158);
        
        int xPos = GAME_AREA.x + 15;
        int yPos = CENTRE_POINT.y - HUGE_FONT_SIZE;
        
        g.setColor(NICE_GRAY_COLOUR);
        g.setFont(HUGE_FONT);
        
        g.drawString("NO MORE BLOBS", xPos, yPos); 
    }
    
    private void drawBorderAreas(Graphics g) {  
        g.setColor(BACKGROUND_COLOUR); 
        g.fillRect(LEFT_OF_GAME_AREA.x, LEFT_OF_GAME_AREA.y, LEFT_OF_GAME_AREA.width, LEFT_OF_GAME_AREA.height); 
        g.fillRect(RIGHT_OF_GAME_AREA.x, RIGHT_OF_GAME_AREA.y, RIGHT_OF_GAME_AREA.width, RIGHT_OF_GAME_AREA.height);  
    } 
    
//-------------------------------------------------------
// Handle MouseEvents - comes here when mouse is pressed
//------------------------------------------------------- 
    public void mousePressed(MouseEvent e) {
        if (noMoreBlobs) {
            initialise();
        } else if (t.isRunning()) {
            t.stop();
        } else {
            t.start();
        }
        
        repaint();
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}




