import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// what package do you need to import here to handle events?

public class Ex4JPanel extends JPanel implements ActionListener {

    // Declare JTextField and JButton instance variables
    private JTextField tNum1;
    private JTextField tNum2;
    private JButton bAdd;
    private JButton bSubtract;
    private JTextField tResult;

    
    public Ex4JPanel() {
        setBackground(Color.YELLOW);
        
        // Construct screen components (e.g. JTextFields, JButtons and JLabels)
        tNum1 = new JTextField(10);
        tNum2 = new JTextField(10);
        bAdd = new JButton("Add");
        bSubtract = new JButton("Subtract");
        tResult = new JTextField(20);
        // Add JTextFields, JButtons and JLabel to the screen in correct order
        add(tNum1);
        add(tNum2);
        add(bAdd);
        add(bSubtract);
        add(new JLabel("Result:"));
        add(tResult);
        
        // Add action listeners to the 2 JButtons.
        bAdd.addActionListener(this);
        bSubtract.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        // get the values from the 2 JTextFields
        double num1 = Double.parseDouble(tNum1.getText());
        double num2 = Double.parseDouble(tNum2.getText());
        double result;
        // Ascertain what button the user has pressed
        if (e.getSource() == bAdd){
        result = num1 + num2;
        tResult.setText("" + result);
        }else{
        result = num1 - num2;
        tResult.setText("" + result);
        }
        //    and add or subtract the values extracted from the JTextFields
        //    then display the result in the third JTextField
        
    }

}