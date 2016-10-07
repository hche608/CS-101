import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex5JPanel extends JPanel {
    
    public Ex5JPanel() {
        int redComponent = (int) (Math.random( )*256);
        int greenComponent = (int)(Math.random( )*256);
        int blueComponent = (int)(Math.random( )*256);
        Color randomColour = new Color(redComponent, greenComponent, blueComponent);
        setBackground(randomColour);     
    }
      
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw 8 houses in different positions and different sizes.
        drawHouse(g,125,177,3);
        drawHouse(g,199,193,7);
        drawHouse(g,292,55,5);
        drawHouse(g,29,110,8);
        drawHouse(g,379,386,7);
        drawHouse(g,127,361,12);
        drawHouse(g,289,28,2);
        drawHouse(g,233,258,16); 
    }
    private void drawHouse(Graphics g, int left, int top, int size) {
        // Put your code in here.
        // Remember everything must be drawn in relation to the left, top and size parameters. 
        g.setColor(Color.BLACK);
        g.drawLine(left + size * 4,top,left, top + size * 4);
        g.drawLine(left + size * 4,top,left + size * 8, top + size * 4);
        g.drawRect(left, top + size * 4, size * 8, size * 6);
        g.drawRect(left, top + size * 4, size * 2, size * 2);
        g.drawRect(left + size * 6, top + size * 4, size * 2, size * 2);
        g.drawRect(left + size * 3, top + size * 6, size * 2, size * 4);
        g.drawOval(left + size * 3, top + size * 8, size, size);
        g.setFont(new Font("Courier", Font.BOLD,size));
        g.drawString("Home",left + size * 3, top + size * 4);
        
    }    
}
