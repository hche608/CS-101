/*
 * Lab 3 Exercise 4
 * Program scrambles the word entered by the user, then prints the new position of a
 *     letter chosen by the user, followed by the scrambled word.
 * Author:
 * Date Written:
 */
public class Ex4Program {
   
    public void start() {
        
    }
    
    private String getWordFromUser() {
        System.out.print("Enter a word: ");
        String word = Keyboard.readInput();
        return word;
    }
    
    private String scrambleTheWord(String word) {
        String lettersRemaining = word;
        String scrambledWord = "";
        for (int i = 0; i < word.length(); i++) {
            int randomPosition = (int)(Math.random()*lettersRemaining.length());
            scrambledWord += lettersRemaining.charAt(randomPosition);
            lettersRemaining = lettersRemaining.substring(0,randomPosition) + lettersRemaining.substring(randomPosition + 1);
        }
        return scrambledWord;
    }
    
    private char askUserForALetter () {
        System.out.print("Choose a letter: ");
        char letter = Keyboard.readInput().charAt(0);
        return letter;
    }
    
    private void printPositionOfLetter(String scrambledWord, char letter) {
        int position = scrambledWord.indexOf(letter);
        System.out.println("This letter is now in position " + position);
    }
    
    private void printScrambledWord(String scrambledWord) {
        System.out.println("The scrambled word is " + scrambledWord);
    }

}
