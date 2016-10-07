/*
 * Lab 3 Exercise 1
 * Program removes a random character from the sentence entered by the user
 * Author:
 * Date Written:
 */
public class Ex1Program {
    
    public void start() {
        
        String sentence = getSentenceFromUser();
        int randomPosition = getRandomPosition(sentence);
        printCharacterToBeRemoved(sentence, randomPosition);
        String changedSentence = removeCharacter(sentence, randomPosition);
        printNewSentence(changedSentence);
        
    }
    // Insert your 5 methods here
}



