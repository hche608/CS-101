
public class Ex8Program {
    
    public void start() {
        
        double[] marks = {46, 34.5, 20, 50, 40.5, 35};
        
        printArray(marks, "Original marks array");
        
        adjustMarks(marks, 2);
        
        printArray(marks, "After multiplying by 2");
        
        adjustMarks(marks, 0.5);
        
        printArray(marks, "After multiplying by 0.5");
        
        
    }
    /*
     * Multiplies each element of the marks array by the scale factor
     */
    private void adjustMarks(double[] marks, double scaleFactor) {
        for (int i = 0; i < marks.length; i++){
            marks[i] = marks [i] * scaleFactor;
        }
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

