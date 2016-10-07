/**
* This program determines whether a given year is a leap year.
*
*/

public class Ex02Program {
    
	public void start() {
        
		int year = getYearFromUser();

		// Enclose the following 6 lines of code in a while loop 
		//    so that the user can continue entering a year until they enter 0    
		while ( year != 0){     
			if (isALeapYear(year) == true) {
				System.out.println(year + " is a leap year.");
			} else {
				System.out.println(year + " is not a leap year.");
			}
			year = getYearFromUser();
			// Insert another call to the getYearFromUser() method to get another year
		}
	}
    
	private int getYearFromUser() {
		System.out.print("Enter a year or 0 to quite: ");
		int year = Integer.parseInt(Keyboard.readInput());
		return year;
	}
	// Complete this method

    
	private boolean isALeapYear(int year) {
		if ( year % 400 == 0 ){
			return true;
		}
		else if( year % 100 == 0){
			return false; 
		}
		else if( year % 4 == 0){
			return true; 
		}else
			return false;
		// Complete this method
	}

}