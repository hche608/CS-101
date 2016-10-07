
public class Ex9Program {

    public void start() {
        
        String word = getWordFromUser();
        while (word.length() > 0) {
            char letter = getLetterFromUser();
            printLetterCount(word, letter);
            word = getWordFromUser();
        }
        
    }
    
    private String getWordFromUser() {
        System.out.print("Enter a word or press return to end: ");
        return Keyboard.readInput();
    }
    
    private char getLetterFromUser() {
        System.out.print("What letter do you want to count? ");
        return Keyboard.readInput().trim().charAt(0);
    }
    
    private void printLetterCount(String word, char letter) {
        
        int count = 0;
        
        // Add in a for loop here that counts up the number of occurrences of letter in word.
        // You will need to use the String method charAt().
        
        
        
        System.out.println("There are " + count + " occurrences of the letter " + letter + " in " + word);
    }



}

