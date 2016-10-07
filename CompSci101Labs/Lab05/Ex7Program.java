
public class Ex7Program {

    public void start() {
        
        double[] marks = {70.5, 32.5, 67, 90, 80.5};
        
        printArray(marks, "Original marks array");
        
        marks = addAnotherMark(marks, 89.5);
        
        printArray(marks, "After adding one more mark");
        
        marks = addAnotherMark(marks, 56.75);
        
        printArray(marks, "After adding another mark");
        
    }
    /*
     * Adds an extra mark into the array of marks
     */
    private double[] addAnotherMark(double[] marks, double mark) {
        
        
        
    }
    
    /*
     * Prints an int array in a nice way.  You do not need to change this method.
     */
    private void printArray(double[] numbers, String arrayName) {
        System.out.println(arrayName + ": ");
        System.out.print("{ ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }



}

