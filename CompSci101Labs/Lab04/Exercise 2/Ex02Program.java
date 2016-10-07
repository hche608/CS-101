/**
 * This program determines whether a given year is a leap year.
 *
 */

public class Ex02Program {
    
    public void start() {
        
        int year = getYearFromUser();
        
        // Enclose the following 6 lines of code in a while loop 
        //    so that the user can continue entering a year until they enter 0    
        
            if (isALeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
            // Insert another call to the getYearFromUser() method to get another year
        
    }
    
    private int getYearFromUser() {
        // Complete this method
    }
    
    private boolean isALeapYear(int year) {
        // Complete this method
    }

}