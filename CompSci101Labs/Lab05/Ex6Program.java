
public class Ex6Program {

    public void start() {
        
        int[] arrayOne = {4, 5, 1, 6, 2, 6, 9 };
        int[] arrayTwo = {6, 1, 0, 10, 4, 6, 3 };
        
        printArray(arrayOne, "Array One");
        printArray(arrayTwo, "Array Two");
        
        int[] arrayThree = addArrays(arrayOne, arrayTwo);
        
        printArray(arrayThree, "Arrays added together");
        
    }
    /*
     * Adds the values of the corresponding elements from the arrays passed
     * in as parameters, and returns a new array containing the sum of each
     * pair of elements
     */
    private int[] addArrays(int[] firstArray, int[] secondArray) {
        int[]arrayThree=new int[firstArray.length];
        for(int i = 0;i<firstArray.length;i++){
            arrayThree[i]=firstArray[i]+secondArray[i];
        }
        return arrayThree;
        
        
        // complete this method
        
        
        
    }
    
    /*
     * Prints an int array in a nice way.  You do not need to change this method.
     */
    private void printArray(int[] numbers, String arrayName) {
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

