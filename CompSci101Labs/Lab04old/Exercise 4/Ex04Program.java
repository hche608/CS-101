/**
 * This program determines whether a person has a healthy BMI (body mass index).
 *
 */

public class Ex04Program {

    public void start() {      
        double weight = getWeightFromUser();
        double height = getHeightFromUser();
        double bodyMassIndex = calculateBMI(weight, height);
        printBMI(bodyMassIndex);
    }
    
    private double getWeightFromUser() {
        System.out.print("Please enter weight in kilograms: ");
        return Double.parseDouble(Keyboard.readInput());     
    }
    
    private double getHeightFromUser() {
        System.out.print("Please enter height in metres: ");
        return Double.parseDouble(Keyboard.readInput());     
    }
    
    private double calculateBMI(double weight, double height) {
        return weight / ( height * height);       
    }
    
    private void printBMI(double bmi) {
        // Complete this method      
    }
}