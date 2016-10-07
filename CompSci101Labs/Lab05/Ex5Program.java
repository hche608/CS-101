
public class Ex5Program {
    
/* Date Written:
 * Author:
*/

    public void start() {
        int n = getNFromUser();
        int[] fibonacciArray = createFibonacciArray(n);
        printFibonacciArray(fibonacciArray);
    }
    
    private int getNFromUser(){ 
        System.out.print("Enter n: ");
        int n = Integer.parseInt(Keyboard.readInput());
        return Math.min(45, n);       // Fibonacci numbers > F45 are too large to fit into an int.
    }
    
    private int[] createFibonacciArray(int n) {
        // Complete this method
        
        
    }
    
    private void printFibonacciArray(int[] fibonacci){  
        System.out.println("Fibonacci numbers:");
        for (int i = 0; i < fibonacci.length; i++) {
            System.out.print(fibonacci[i] + ", ");
        }
        System.out.println("...");
    }
}
