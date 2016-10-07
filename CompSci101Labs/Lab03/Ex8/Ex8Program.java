/*
 * Lab 3 Exercise 8
 * Program calculates the number of words in a sentence.
 * Author:
 * Date Written:
 */

 public class Ex8Program {
     public void start() {
         String sentence = getSentenceFromUser();
         int numberOfWords = calculateNumberOfWords(sentence);
         printResult(sentence, numberOfWords);
     }
     private String getSentenceFromUser() {
         System.out.print("Enter a sentence: ");
         return Keyboard.readInput();
     }
     
     private int calculateNumberOfWords(String sentence) {
         int count = 1;
         for (int i = 0; i < sentence.length(); i++) {
             if (sentence.charAt(i) == ' ') {
                 count++;
             }
         }
         return count;
     }
     
     private void printResult(String sentence, int numberOfWords) {
         System.out.println("There are " + numberOfWords + " words in the sentence \"" + sentence + "\".");
     }
     
}
