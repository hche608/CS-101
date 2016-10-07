/*
 * Lab 3 Exercise 5
 * Program extracts the first initial and surname from the user's name.

 * Author:
 * Date Written:
 */
public class Ex5Program {

// start() method has already been written for you - DO NOT change other than removing the //'s when you
// are ready to test the method.
    
    public void start() {
        String name = getNameFromUser();
        char initialOfFirstName = getInitial(name);
        String surname = extractSurname(name);
        printGreeting(initialOfFirstName, surname);
    }
    
    
    // Insert the getNameFromUser() method here
    private String getNameFromUser(){
        System.out.print("Enter your name: ");
        String name = Keyboard.readInput();
        return name;
    }
    // Insert the getInitial() method here
    private char getInitial(String userName){ 
        char initialName = userName.charAt(0);
        return initialName;
        
    }
    // Insert the extractSurname() method here
    private String extractSurname(String userName){
        int position = userName.indexOf(" ");
        String surname = userName.substring(position + 1);
        return surname;        
    }
    // Insert the printGreeting() method here
    private void printGreeting(char initialOfFirstName, String surname){
        System.out.println("Hi " + initialOfFirstName + ". " + surname);
    }
}
