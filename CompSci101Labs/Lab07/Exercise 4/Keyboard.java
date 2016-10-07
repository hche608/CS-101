/*
 * CompSci 101 - Keyboard Class
 * ============================
 * This class is used for input from the keyboard. 
 * YOU DO NOT NEED TO UNDERSTAND THE DETAILS OF THIS CLASS. 
 * To use this class, put it in the same directory as the source file for your program, and include the 
 * statement:
 * String input = Keyboard.readInput(); in your program. 
 * This will assign whatever is typed at the keyboard to the input variable.
 * 
 */
import java.util.*;

public class Keyboard {	
	private static Scanner in = new Scanner(System.in);

	public static String readInput() {
		try {
			return in.nextLine();
		} catch (IllegalStateException e) {
			System.err.println("An error has occurred in the Keyboard.readInput() method.");
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
}
