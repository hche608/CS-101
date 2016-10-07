import java.util.*;

public class StarsProgram {
    
    public void start() {
        Star[] stars = getArrayOfStars();
        //Star brightest = getBrightestStar(stars);
        //printBrightestStar(brightest);
        //printCoordinatesOfStar(stars, "ELECTRA");
        //printStarsWithMoreThanOneName(stars);
        //printStarClosestToOrigin(stars);
    }
    
    // Read the Stars data from the file and store in the stars array.
    private Star[] getArrayOfStars() {
        int howMany = Integer.parseInt(Keyboard.readInput());
        Star[] stars = new Star[howMany];
        for (int i = 0; i < stars.length; i++) {
            String input = Keyboard.readInput();
            Scanner fields = new Scanner(input);
            double x = Double.parseDouble(fields.next());
            double y = Double.parseDouble(fields.next());
            double z = Double.parseDouble(fields.next());
            int draper = Integer.parseInt(fields.next());
            double magnitude = Double.parseDouble(fields.next());
            int harvardRevisedNumber = Integer.parseInt(fields.next());
            String namesString = "";
            String[] names = {};
            if (fields.hasNext()) {
                namesString = fields.nextLine();
                names = namesString.trim().split("; ");
            }
            stars[i] = new Star(x, y, z, draper, magnitude, names);
        }
        return stars;
    }
    
    private Star getBrightestStar(Star[] stars) {
        // You write the code to find and return the brightest star
    }
    
    private void printBrightestStar(Star brightest) {
        // You write the code to print the star passed in as a parameter
    }
    
    private void printCoordinatesOfStar(Star[] stars, String name) {
        // You write the code to search for and print the coordinates
        // of the Star with the name that was passed in as a parameter
    }
    
    private void printStarsWithMoreThanOneName(Star[] stars) {
        // You write the code to print all Stars which have more than 1 name
    }
    
    private void printStarClosestToOrigin(Star[] stars) {
        // You write the code to find and print the Star which is closest to the origin
    }

}
