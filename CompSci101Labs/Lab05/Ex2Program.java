
public class Ex2Program {


    public void start() {
        
        System.out.print("Enter the size or 0 to exit: ");
        int size = Integer.parseInt(Keyboard.readInput());
        
        while (size !=0) {
            printPattern(size);
            System.out.print("Enter the size or 0 to exit: ");
            size = Integer.parseInt(Keyboard.readInput());
        }
    }
    
    private void printPattern(int size) {
        while (  )
        // You complete this method
    }
    
    /*
     * Prints a line of dashes.
     */
    private void printLineOfDashes(int howMany) {
        for (int i = 0; i < howMany; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
