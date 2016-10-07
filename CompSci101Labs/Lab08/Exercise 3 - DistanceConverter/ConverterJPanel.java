import java.awt.*;
import javax.swing.*;
// what package do you need to import here to handle events?

public class ConverterJPanel extends JPanel // What do you need here? {
    
    // Declare JTextField and JButton instance variables
    
    public ConverterJPanel() {
        setBackground(Color.CYAN);
        
        // construct screen components (i.e. the 2 JTextFields, 2 JButtons and 2 JLabels)
        
        // add JTextFields, JButtons and JLabels to the screen in correct order
        
        // add Action Listeners to the two JButtons.
    }
    
    public void actionPerformed(ActionEvent e) {
        final double CONVERSION_FACTOR = 1.60934;
        double miles, kms;
        
        //  Ascertain what button the user has pressed
        
        //  Then extract the distance from the appropriate JTextField,
        //     and convert the distance from kms to miles, or from miles to kms
        //     depending on what JButton the user has pressed,
        //     then display the result in the other JTextField.
        
    }

}
