
public class Ex2Program {

    public void start() {
        Medals newZealand = new Medals("New Zealand", 4, 12, 13);
        Medals australia = new Medals("Australia", 3, 20, 10);
        Medals canada = new Medals("Canada", 6, 5, 7);
        
        printMedalStatus(newZealand, australia, canada);
        
        printWinners(newZealand, australia, canada);
    }
    
    public void printMedalStatus(Medals nZ, Medals aussie, Medals canada) {
        System.out.println(nZ.toString());
        System.out.println(aussie.toString());
        System.out.println(canada.toString());
        System.out.println();
    }
    
    public void printWinners(Medals nZ, Medals aussie, Medals canada) {
        compareMedals(nZ, aussie, canada);
        compareMedals(canada, aussie, nZ);
        compareMedals(aussie, nZ, canada);
    }
    
    private void compareMedals(Medals countryOne, Medals countryTwo, Medals countryThree) {
        
        if (countryOne.hasMoreGoldMedalsThan(countryTwo)
                && countryOne.hasMoreGoldMedalsThan(countryThree)) {
            System.out.println(countryOne.getCountryName() + " has the most gold medals");
        }
        
        if (countryOne.isHigherThan(countryTwo) && countryOne.isHigherThan(countryThree)) {
            System.out.println(countryOne.getCountryName() + " is the overall winner");
        }
    }

}
