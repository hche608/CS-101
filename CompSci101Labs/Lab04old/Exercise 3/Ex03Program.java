/**
 * This program determines whether 2 names are the same, have the
 * same initial or do not match in any way.
 *
 */

public class Ex03Program {

    public void start() {
        boolean userWantsToContinue = true;
        while (userWantsToContinue) {
            String firstName = getNameFromUser("first");
            String secondName = getNameFromUser("second");
            printMessage(firstName, secondName);
            userWantsToContinue = askIfUserWantsToContinue();
        }
    }
    
    private String getNameFromUser(String firstOrSecond) {
        System.out.print("Enter the name of the " + firstOrSecond + " person: ");
        return Keyboard.readInput();
    }
    
    
    private void printMessage(String firstName, String secondName) {
        // Complete this method according to the lab handout
    }
    
    private boolean askIfUserWantsToContinue() {
        // Complete this method according to the lab handout
    }


}