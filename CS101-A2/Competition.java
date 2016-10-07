/*
 * ============================
 *  UPI : HCHE608
 * ============================
 * CompSci 101 S2 2013
 * 
 * Class
 * Purpose: The Application for
 * a Competiton Class
 *
*/

public class Competition {
    public static final int MAX_RACES = 50;
    public static final int MAX_COMPETITORS = 50;
    
    private String venue;
    private Race[] races;
    private int numberOfRaces;
    private Competitor[] competitors;
    private int numberOfCompetitors;
    
    public Competition(String venue) {
        this.venue = venue;
        this.races = new Race[MAX_RACES];
        this.numberOfRaces = 0;
        this.competitors = new Competitor[MAX_COMPETITORS];
        this.numberOfCompetitors = 0;
        
    }
    
    public String getVenue() {
        return venue;
    }
    
    public Competitor[] getCompetitors() { 
        Competitor[] newCompetitors = new Competitor[numberOfCompetitors];
        for ( int i = 0; i < numberOfCompetitors; i++){
            newCompetitors[i] = competitors[i];
        }
        return newCompetitors;
    }
    
    public Race[] getRaces() {
        Race[] newRace = new Race[numberOfRaces];
        for ( int i = 0; i < numberOfRaces; i++){
            newRace[i] = races[i];
        }
        return newRace;
    }
    
    public Race addRace(int typeIndex, MyDate date) {
        Race newRace = null;
        if ( numberOfRaces < MAX_RACES ){
            races[numberOfRaces] = new Race(numberOfRaces+1, typeIndex, date);
            newRace = races[numberOfRaces];       
            numberOfRaces++;
        } 
        return newRace;
    }
    
    public Competitor addCompetitor(int number, String name, int age, int typeIndex) {
        Competitor newCompetitor = null;
        if ( numberOfCompetitors < MAX_COMPETITORS ){
            competitors[numberOfCompetitors] = new Competitor(name, number, typeIndex, age);
            newCompetitor = competitors[numberOfCompetitors];
            numberOfCompetitors++;
        }
        return newCompetitor;
    }
    
    public Race getRace(int number) { 
        Race matchRace = null;
        for (int i = 0; i < numberOfRaces; i++){
            if ( races[i].getNumber() == number ){
                matchRace = races[i];
            }
        }
        return matchRace;
    }
    
    public Competitor getCompetitor(int number) {
        Competitor matchCompetitor = null;
        for (int i = 0; i < numberOfCompetitors; i++){
            if ( competitors[i].getNumber() == number ){
                matchCompetitor = competitors[i];
            }
        }
        return matchCompetitor;
    }
    
    public int calculateFinalScore(int number) { 
        int score = 0;
        for (int i = 0; i < numberOfRaces; i++) {
            Competitor competitor = races[i].getCompetitor(number);
            if (competitor != null) {
                int position = competitor.getPosition();
                if (position == 1) {
                    score += 3;
                } else if (position == 2) {
                    score += 2;
                } else if (position == 3) {
                    score += 1;
                }
            }
        }
        return score;
    }
    
    public boolean addCompetitorToRace(int competitor, int race) {
        Race raceInstance = getRace(race);
        Competitor competitorInstance = getCompetitor(competitor);
        if ((raceInstance == null) || (competitorInstance == null)) {
            return false;
        }
        Competitor competitorToAdd = new Competitor(competitorInstance.getName(), competitorInstance.getNumber(), 
                                                    competitorInstance.getTypeIndex(), competitorInstance.getAge());
        return raceInstance.addCompetitor(competitorToAdd);
    }
    
    public String getTop10Competitors() { 
        int[] scores = new int[numberOfCompetitors];
        for (int i = 0; i < numberOfCompetitors; i++) {
            Competitor competitor = competitors[i];
            scores[i] = calculateFinalScore(competitor.getNumber());
        }   
        Competitor[] sortedCompetitors = new Competitor[numberOfCompetitors];
        int[] sortedScores = new int[numberOfCompetitors];
        for (int i = 0; i < numberOfCompetitors; i++) {
            int maxScore = scores[0];
            int maxScoreIndex = 0;
            for (int j = 1; j < numberOfCompetitors; j++) {
                if (scores[j] > maxScore) {
                    maxScore = scores[j];
                    maxScoreIndex = j;
                }
            }
            sortedCompetitors[i] = competitors[maxScoreIndex];
            sortedScores[i] = scores[maxScoreIndex];
            scores[maxScoreIndex] = -1;
        }
        String top10String = "";
        for (int i = 0; (i < numberOfCompetitors) && (i < 10); i++){
            Competitor competitor = sortedCompetitors[i];
            top10String = top10String + (i + 1) + ": " + competitor.getNumber() + ", " + competitor.getName() + " = " + sortedScores[i] + "\n";
        }
        return top10String;
    }  
    
    public String toString() { 
        return "Competition held at " + venue + "\nTop 10 competitors were:\n" + getTop10Competitors();
    }
}
