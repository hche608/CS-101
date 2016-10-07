/**
 * This program generates a fourth random number that does not already exist in the number string..
 *
 */

public class Ex05Program {
    
    public void start() {
        
        String numberString = getNumberString();
        numberString += " " + getUniqueRandomNumber(numberString);
        printNumberString(numberString);
    }
    
    private String getNumberString() {
        System.out.print("Enter 3 numbers between 1 and 20 with a space between each: ");
        String numbers = Keyboard.readInput();
        return numbers.trim();
    }
    
    private String getUniqueRandomNumber(String numberString) {
        int randomNumber = 0;
        boolean uniqueNumberGenerated = false;
        while ( ! uniqueNumberGenerated ) {
            randomNumber = (int) (Math.random() * 20 + 1);
            uniqueNumberGenerated = checkIfUnique(randomNumber, numberString);
        }
        return randomNumber + "";
    }
    
    
    private boolean checkIfUnique(int randomNumber, String numberString) {
        // Complete this method
        
        
        
    }
    
    private void printNumberString(String numberString) {
        System.out.println("Four numbers are: " + numberString.trim());
    }

}