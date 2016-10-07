
public class Ex1Program {
    
    public void start() {
        
        int[] arrayOne = {4, 5, 1, 6, 2};
        int[] arrayTwo = {6, 1, 0};
        int[] arrayThree = {9, 3, 1, 5, 2, 0, 4, 6, 7, 8};
        
        System.out.println("Before:");
        printArray(arrayOne);
        printArray(arrayTwo);
        printArray(arrayThree);
        
        rotateElements(arrayOne);
        rotateElements(arrayTwo);
        rotateElements(arrayThree);
        
        System.out.println();
        System.out.println("After being rotated");
        printArray(arrayOne);
        printArray(arrayTwo);
        printArray(arrayThree);
        
    }
    
    /*
     * Prints an int array in a pretty way.
     */
    private void printArray(int[] numbers) {
        System.out.print("{ ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i != numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
    
    /*
     * Rotates all elements in the array one
     * position to the left. The first element is moved
     * to the end of the array.
     */
    private void rotateElements(int[] numbers) {
        int num = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[numbers.length - 1] = num;
    }
    
// complete this method
}


