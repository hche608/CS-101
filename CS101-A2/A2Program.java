/*
 * ============================
 *  UPI : HCHE608
 * ============================
 * CompSci 101 S2 2013
 * 
 * Main Program
 * Purpose: The Application for
 * a Competiton database program
 *
*/

public class A2Program {
    private Competition[] competitions;  
    private int numberOfCompetitions;
    private Competition currentCompetition;

    public A2Program(){
        currentCompetition = null;
    }

//----------------------------------------------------------------
//-------- Runs the program
//----------------------------------------------------------------
    public void start() {
        readFromFile();
        int option = -1;
        while (option != 0){
            displayMenu();
            option = getNumberFromKeyboard("Enter selection");
            if (option == 1) {
                changeCompetition();
            } else if (option == 2) {
                displayRaces(currentCompetition);
            } else if (option == 3) {
                addCompetitorToRace(currentCompetition);
            } else if (option == 4) {
                recordRaceResult(currentCompetition);
            } else if (option == 5) {
                displayResults(currentCompetition);
            } else if (option != 0){
                System.out.println("Unknown option!");
            }
        }
    }

//----------------------------------------------------------------
//-------- Display the welcome information
//----------------------------------------------------------------
    private void displayWelcome() {
        System.out.println("==========================");
        System.out.println("Welcome to Dunrobin Cycling Competitions - by hche608");
        System.out.println("==========================");
    } 

//----------------------------------------------------------------
//-------- Display the menu
//----------------------------------------------------------------
    private void displayMenu() { 
        displayWelcome();
        System.out.println("Please select an option:");
        System.out.println("1: Choose competition");
        System.out.println("2: Display races");
        System.out.println("3: Add competitor to race");
        System.out.println("4: Record race result");
        System.out.println("5: Display competition results");
        System.out.println("0: Exit");
        System.out.println();
    }  

//----------------------------------------------------------------
//-------- Change the competition
//----------------------------------------------------------------
    private void changeCompetition() { 
        Boolean isValid = false;
        while (!isValid) {
            displayCompetitions();
            System.out.println();
            int number = getNumberFromKeyboard("Select a competition");
            if (number < numberOfCompetitions) {
                currentCompetition = competitions[number];
                isValid = true;
            } else{ 
                System.out.println(number + " is an invalid option, please try again");
            }
        }
    }  

//----------------------------------------------------------------
//-------- Display the competitions
//----------------------------------------------------------------
    private void displayCompetitions() { 
        for (int i = 0; i < competitions.length; i++){
            System.out.println("" + i + ": " + competitions[i].getVenue());
        }
    }

//----------------------------------------------------------------
//-------- Display the races for the current competition
//----------------------------------------------------------------
    private void displayRaces(Competition current) {
        if ( current == null){
            System.out.println("Please choose a competition before trying to display the races.");
        } else {
            System.out.println("Venue: " + current.getVenue());
            Race[] tempRaces = current.getRaces();
            for (int i = 0; i < tempRaces.length; i++){
                System.out.println(tempRaces[i].toString());
            }
        }
    }   

//----------------------------------------------------------------
//-------- Display the results for the current competition
//----------------------------------------------------------------
    private void displayResults(Competition current) { 
        if (current == null){
            System.out.println("Please select a competition first");
        } else {
            Competitor[] competitors = current.getCompetitors();
            for (int loop = 0; loop < competitors.length; loop++) {
                Competitor competitor = competitors[loop];
                int finalScore = current.calculateFinalScore(competitor.getNumber());
                System.out.println("The final score for " + competitor + " is " + finalScore);
            }      
            String topTen = current.getTop10Competitors();
            System.out.println("The top ten competitors are");
            System.out.println(topTen);
        }
    }

//----------------------------------------------------------------
//-------- Records a race result
//----------------------------------------------------------------
    private void recordRaceResult(Competition current) { 
        if (current == null){
            System.out.println("Please select a competition first");
        } else{
            Race race = getRace(current, "Select a race");
            if (race != null) {
                Competitor first = getCompetitor(current, "Who was first place");
                if (first != null) {
                    Competitor second = getCompetitor(current, "Who was second place");
                    if (second != null) {
                        Competitor third = getCompetitor(current, "Who was third place");
                        if (third != null) {
                            race.finishRace(first.getNumber(), second.getNumber(), third.getNumber());
                            System.out.println(race);
                        }
                    }
                }
            }
        }
    } 

    private Race getRace(Competition current, String prompt) {
        int raceNumber = getNumberFromKeyboard(prompt);
        Race race = current.getRace(raceNumber);
        if (race == null) {
            System.out.println("This is not a valid race");
        }
        return race;
    }

    private Competitor getCompetitor(Competition current, String prompt){
        int number = getNumberFromKeyboard(prompt);
        Competitor competitor = current.getCompetitor(number);
        if (competitor == null) {
            System.out.println("This is not a valid competitor");
        }
        return competitor;
    }

//----------------------------------------------------------------
//-------- Adds a competitor
//----------------------------------------------------------------
    private void addCompetitorToRace(Competition current) { 
        if (current == null){
            System.out.println("Please select a competition first");
        } else{
            Race race = getRace(current, "Select a race");
            if (race != null) {
                Competitor competitor = getCompetitor(current, "Select a competitor");
                if (competitor != null) {
                    race.addCompetitor(competitor);
                }
            }
        }
    }

//----------------------------------------------------------------
//-------- Gets a number from the keyboard
//----------------------------------------------------------------
    private int getNumberFromKeyboard(String prompt) {
        System.out.print(prompt + ": ");
        int num = Integer.parseInt(Keyboard.readInput());  
        return num; 
    }

//----------------------------------------------------------
//----------------------------------------------------------
//----------------------------------------------------------
// DO NOT CHANGE ANY CODE BELOW THIS LINE
// The code below reads all the information
// from the Competitions.txt file and correctly
// creates the array of Competition objects
// YOU DO NOT NEED TO UNDERSTAND ANY OF THIS CODE (it is
// outside the scope of COMPSCI 101)
//----------------------------------------------------------
//----------------------------------------------------------
//----------------------------------------------------------
    private void readFromFile() {
        String lineOfInput;
        java.util.Scanner scan = null;
        java.util.Scanner lineScanner;
        Competition current = null;
        numberOfCompetitions = 0;
        java.util.ArrayList<Competition> array = new java.util.ArrayList<Competition>();
        try {
            scan = new java.util.Scanner(new java.io.File("Competitions.txt"));
        } catch (java.io.IOException e) {}
        while (scan.hasNext()) {
            lineOfInput = scan.nextLine();
            String[] parts;
            String lineType = lineOfInput.substring(0, 1);
            if (lineType.equals("V")) {
                current = new Competition(lineOfInput.substring(2));
                numberOfCompetitions++;
                array.add(current);
            } else if (lineType.equals("C")) {
                parts = lineOfInput.substring(2).split(",");
                int number = Integer.parseInt(parts[0]);
                int age = Integer.parseInt(parts[3]);
                int type = Integer.parseInt(parts[2]);
                current.addCompetitor(number, parts[1], age, type);
            } else if (lineType.equals("R")) {
                parts = lineOfInput.substring(2).split(",");
                MyDate date = new MyDate(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                Race race = current.addRace(Integer.parseInt(parts[1]), date);
                for (int loop = 5; loop < parts.length; loop++) {
                    int number = Integer.parseInt(parts[loop]);
                    current.addCompetitorToRace(number, race.getNumber());
                }
            } else if (lineType.equals("F")) {
                parts = lineOfInput.substring(2).split(",");
                int raceNumber = Integer.parseInt(parts[0]);
                int first = Integer.parseInt(parts[1]);
                int second = Integer.parseInt(parts[2]);
                int third = Integer.parseInt(parts[3]);
                Race race = current.getRace(raceNumber);
                race.finishRace(first, second, third);
            }
        }
        competitions = array.toArray(new Competition[numberOfCompetitions]);
        scan.close();
        System.out.println("Finished reading file - " + numberOfCompetitions + " venues loaded");
    }
}
