public class Pattern {

    // Instance variables
    
    private int numberOfCharacters;  // number of repetitions of the symbol in the Pattern
    private char symbol;   // the symbol to be used in the Pattern
    
    public Pattern(int numberOfCharacters, char symbol) {
        this.numberOfCharacters = numberOfCharacters;
        this.symbol = symbol;
    }
    
    public String toString() {
        String pattern = "";
        for (int i = 0; i < numberOfCharacters; i++) {
            pattern += symbol;
        }
        return pattern;
    }
    
    public void setNumberOfCharacters(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }
    
    public int getNumberOfCharacters() {
        return numberOfCharacters;
        
    }
    
    public void setSymbol(char symbol) {
        this.symbol = symbol;
        
    }
    
    public char getSymbol() {
        return symbol;
    }
    
    public boolean equals(Pattern other) {
        return numberOfCharacters == other.numberOfCharacters && symbol == other.symbol;
    }

}
