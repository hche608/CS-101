
public class Ex06Program {
    
    public void start() {
        playGuessingGame();
    }
    
    private void playGuessingGame() {
        // Complete this method according to the lab handout    
        int goal = (int) (Math.random()*100 +1 );
        int guess = getguess(); 
        while ( goal != guess){                       
            if ( goal > guess ){
                System.out.println("Too low, try again");
                //guess = getguess();
            }
            else if(goal < guess){
                System.out.println("Too high, try again");
                //guess = getguess();
            } 
            guess = getguess();
        }
        System.out.println("Perfect!\nGoodbye");
    }    
    private int getguess() {
        System.out.print("Enter a number(1 - 100): ");
        int guess = Integer.parseInt(Keyboard.readInput());
        return guess;
    }
}