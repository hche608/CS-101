/**
 * This program plays the game,
 * Rock, Paper, Scissors.
 *
 * Author:
 * Date Written: January, 2012
 *
 */

public class Ex01Program {
    
    public static final int ROCK = 1;
    public static final int SCISSORS = 2;
    public static final int PAPER = 3;
    public static final int QUIT = 4;
    
    public void start() {
        String usersName = getUsersName();
        boolean userWantsToPlay = true;
        
        while (userWantsToPlay) {
            showUserChoices();
            int userChoice = getUserChoice();
            userWantsToPlay = userChoice != QUIT;
            if (userWantsToPlay) {
                int computerChoice = getComputerChoice();
                displayPlayerChoice(usersName, userChoice);
                displayPlayerChoice("Computer", computerChoice);
                String winnerString = workOutWinner(userChoice, computerChoice, usersName);
                displayWinner(winnerString);
            }
        }
        displayGoodbyeMessage(usersName);
    }
    
    private String getUsersName() {
        System.out.print("Hi!  What is your name? ");
        String name = Keyboard.readInput();
        System.out.println();
        return name;
    }
    
    private void showUserChoices() {
        System.out.println(ROCK + ". Rock");
        System.out.println(SCISSORS + ". Scissors");
        System.out.println(PAPER + ". Paper");
        System.out.println(QUIT + ". Quit");
    }
    
    private int getUserChoice() {
        System.out.print("   Enter choice: ");
        String userString = Keyboard.readInput();
        
        userString = userString.trim();
        System.out.println();
        return Integer.parseInt(userString);
    }
    
    private int getComputerChoice() {
        return (int) (Math.random() * 3 + 1);
    }
    
    private String workOutWinner(int userChoice, int computerChoice, String usersName) {
        String winnerString = " ";
        
        if (userChoice == computerChoice) {
            winnerString = "  No one";
        } else if (userWins(userChoice, computerChoice)) {
            winnerString = " " + usersName;
        } else {
            winnerString = "  The computer";
        }
        winnerString = winnerString + " wins because " + getResultString(userChoice, computerChoice);
        return winnerString;
    }
    
    private void displayWinner(String winner) {
        System.out.println(winner);
        System.out.println();
    }
    
    private void displayGoodbyeMessage(String name) {
        System.out.println("Goodbye " + name + ". Thanks for playing :)");
    }
    
    
    
//************************** Ex 1a ******************************
    
    private void displayPlayerChoice(String player, int choice) {
        
        // complete this method according to Ex 1a in the handout
        
    }
    
//************************** Ex 1b ******************************
    
    private boolean userWins(int userChoice, int computerChoice) {
        
        // complete this method according to Ex 1b in the handout.
        // if the user wins, return true, otherwise return false
        
        return false;
    }
    
//************************** Ex 1c ******************************
    
    private String getResultString(int choice1, int choice2) {
        
        final String PAPER_WINS = "paper covers rock";
        final String ROCK_WINS = "rock smashes scissors";
        final String SCISSORS_WINS = "scissors cut paper";
        final String TIE = "you chose the same as the computer";
        
        // complete this method using the symbolic constants above, according to Ex 1c in the handout
        
        return ""; // Replace this whole line with your own lines of code.

 }

//**************************************************************

}
