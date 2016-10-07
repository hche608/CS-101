/**
 * This program determines whether a person has a healthy BMI (body mass index).
 *
 */

public class Ex04Program {
    
    public void start() {      
        int[] originalDeckOfCards;
        originalDeckOfCards = new int [52];
        for (int i = 1; i <=52; i++){ 
            originalDeckOfCards[i-1] = i;            
            System.out.print(i + ".");
        }
        System.out.println("");     
        
//System.out.println(originalDeckOfCards(0,52));
        int[] shuffledCards;
        shuffledCards = originalDeckOfCards; 
        
        for (int i = 0; i < 1000; i++){
            int randomNum = (int) (Math.random()*52);
            int randomNum2 = (int) (Math.random()*52);
            int temp1, temp2;
            temp1 = shuffledCards[randomNum];
            temp2 = shuffledCards[randomNum2];
            shuffledCards[randomNum2] = temp1;
            shuffledCards[randomNum] = temp2;
            
        }
        System.out.println("");
        for (int i = 0; i <52; i++){
            System.out.print(shuffledCards[i] + ".");
        }      
    }
}