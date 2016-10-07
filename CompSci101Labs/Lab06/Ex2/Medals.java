public class Medals {
    
    // Instance variables:
    
    private String countryName; // name of country
    private int golds;   // number of gold medals
    private int silvers;  // number of silver medals
    private int bronzes;  // number of bronze medals
    
    
    public Medals(String countryName, int golds, int silvers, int bronzes ) {
        // constructor method to initialize the instance variables
        // Parameters are in the order: country, golds, silvers, bronzes
        this.countryName = countryName;
        this.golds = golds;
        this.silvers = silvers;
        this.bronzes = bronzes;
    }
    
    public String getCountryName() {
        // accessor method to return the country name instance variable
        return countryName;
    }
    
    public void setCountryName(String countryName) {
        // mutator method to set the country name instance variable
        this.countryName = countryName;
    }
    
    public boolean isHigherThan(Medals other) {
        // Compare the other Medals object with this one.
        // The other Medals object is passed in as a parameter
        // return true if the current Medals object is higher (in terms of medals value)
        //  than the other.
        int medalValue = golds * 3 + silvers * 2 + bronzes;
        int otherMedalValue = other.golds * 3 + other.silvers * 2 + other.bronzes;
        return medalValue > otherMedalValue;
    }
    
    public boolean hasMoreGoldMedalsThan(Medals other) {
        // Method that returns true if this country has more gold medals than the other.
        // Otherwise it returns false.
        return golds > other.golds;
    }
    
    
    public String toString() {
        // return a String representing the instance variables formatted as per the hand-out.
        String info = "";
        info += countryName + " has " + golds + " gold medals, " + silvers + " silvers medals, "+ bronzes + " bronzes medals";
        return info;    
    }
    
}

