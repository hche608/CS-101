import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoveBoxesJFrame extends JFrame {

    public RemoveBoxesJFrame(String title, int x, int y, int width, int height) {
        
        setTitle(title);
        setBounds(x, y, width, height);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel frameContent = new RemoveBoxesJPanel();
        
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
        
        setVisible(true);
    }
}