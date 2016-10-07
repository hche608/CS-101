/**
 * This program plays the game,
 * Rock, Paper, Scissors.
 *
 * Author:
 * Date Written: January, 2012
 *
 */

public class Ex01Program {
    
    
    public void start() {
        for (int i = 0; i < 101;i++){
            double num = 0.1;
            num = num + 0.1*i;
            
            System.out.println(num);
            System.out.println(num == 0.1*i);
            
        }
    }
}