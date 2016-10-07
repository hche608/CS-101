/*
 * ============================
 *  UPI : HCHE608
 * ============================
 * CompSci 101 S2 2013
 * 
 * Class
 * Purpose: The Application for
 * a Race Class
 *
*/

public class Race {
    public static final String[] RACE_DESCRIPTIONS = {"Sprint", "Distance", "Eliminator", "Keirin"};
    public static final int SPRINT = 0;
    public static final int DISTANCE = 1;
    public static final int ELIMINATOR = 2;
    public static final int KEIRIN = 3;
    public static final int MAX_COMPETITORS = 8;
    
    private int number;
    private int typeIndex;
    private MyDate date;
    private boolean hasFinished;
    private Competitor[] competitors;
    private int numberOfCompetitors;
    
    private String[] indexOfPosition = {"n/a", "n/a", "n/a"};
    
    public Race(int number, int typeIndex, MyDate date) { 
        this.number = number;
        this.typeIndex = typeIndex;
        this.date = date;
        this.hasFinished = false;
        this.competitors = new Competitor[MAX_COMPETITORS];
        this.numberOfCompetitors = 0;
    }
    
    public int getNumber() {
        return number;
    }
    
    public boolean getHasFinished() {
        return hasFinished;
    }
    
    public int getTypeIndex() {
        return typeIndex;
    }
    
    public MyDate getDate() {
        return date;
    }
    
    public Competitor getCompetitor(int number) {        
        Competitor theCompetitor;
        theCompetitor = null;
        for ( int i = 0; i < numberOfCompetitors; i++){
            if ( competitors[i].getNumber() == number){
                theCompetitor = competitors[i];
            } 
        }
        return theCompetitor;
    }   
    
    public void finishRace(int first, int second, int third) { 
        if ( first != -1 || second != -1 || third != -1 ){
            hasFinished = true;
            for (int i = 0; i < numberOfCompetitors; i++){
                if (competitors[i].getNumber() == first ){
                    competitors[i].setPosition(1);
                    indexOfPosition[0] = competitors[i].getName();
                } else if (competitors[i].getNumber() == second ){
                    competitors[i].setPosition(2);
                    indexOfPosition[1] = competitors[i].getName();
                } else if (competitors[i].getNumber() == third ){
                    competitors[i].setPosition(3);
                    indexOfPosition[2] = competitors[i].getName();
                } else {
                    competitors[i].setPosition(0);
                }
            }
        }
    }
    
    
    public boolean addCompetitor(Competitor competitor) {
        if ( numberOfCompetitors < MAX_COMPETITORS){
            competitors[numberOfCompetitors] = competitor;
            numberOfCompetitors++;
            return true;
        } else {
            return false;
        }
    }
    
    
    public String toString() {     
        String info = "";
        
        if ( !hasFinished ){
            info += number + ", " + RACE_DESCRIPTIONS[typeIndex] + " [" + date + "]: Race not finished";
        } else {
            info += number + ", " + RACE_DESCRIPTIONS[typeIndex] + " [" + date + "]" + "\n     1st: " + indexOfPosition[0] + "\n     2nd: " + indexOfPosition[1] + "\n     3rd: " + indexOfPosition[2];       
        }
        return info;
    }
}
