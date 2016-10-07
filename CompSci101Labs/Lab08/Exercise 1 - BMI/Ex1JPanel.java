import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex1JPanel extends JPanel implements ActionListener{
    
    // declare JTextFields and JButtons as instance variables
    
    public Ex1JPanel() {
        setBackground(Color.white);
        
        // construct JTextFields and JButtons
        
        // declare and construct JLabels
        
        // add JLabels, JTextFields and JButtons to window
        
        // add Action Listeners for the 2 JButtons
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        double height, weight, bodyMassIndex, healthyWeight;
        
        /*  Calculate and display either the BMI
         or maximum healthy weight depending on which
         JButton was pressed.
         */
    }
    
    private double roundTo2DecimalPlaces(double amount) {
        String amountString = "" + amount + "0";
        int positionOfPoint = amountString.indexOf(".");
        amountString = amountString.substring(0,positionOfPoint + 3);
        return Double.parseDouble(amountString);
    }

}
