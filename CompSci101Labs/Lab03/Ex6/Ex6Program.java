/*
 * Lab 3 Exercise 6
 * Program extracts and prints 3 rows and a left diagonal from a String of 18 characters.
 * Each row contains 6 characters.
 * Author:
 * Date Written: August, 2012
 */

 public class Ex6Program {
     public void start() {
         String letters = "X X O O X O X O X ";
         String row1 = getRow(letters, 1);
         String row2 = getRow(letters, 2);
         String row3 = getRow(letters, 3);
         printRows(row1, row2, row3);
         String leftDiagonal = getLeftDiagonal(row1, row2, row3);
         printDiagonal(leftDiagonal);
     }
     
     private String getRow(String letters, int rowNumber) {
         return ""; // Remove this line when you develop the method.
     }
     
     private void printRows(String firstRow, String secondRow, String thirdRow) {
         
     }
     
     private String getLeftDiagonal(String row1, String row2, String row3) {
         return ""; // Remove this line when you develop the method.
     }
     
     private void printDiagonal(String diagonal) {
         
     }
}
