import java.awt.*;
import javax.swing.*;

public class Ex1JFrame extends JFrame {
    
    public Ex1JFrame(String title, int x, int y, int width, int height) {
        
        setTitle(title);
        setBounds(x, y, width, height);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel frameContent = new Ex1JPanel();
        
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
        
        setVisible(true);
    }
}