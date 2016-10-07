/*
 * ============================
 *  UPI : HCHE608
 * ============================
 * CompSci 101 S2 2013
 * 
 * Class
 * Purpose: The Application for
 * a Competitor Class
 *
*/

public class Competitor {
    public static final String[] COMPETITOR_DESCRIPTIONS = {"A Grade", "B Grade", "Senior"};
    public static final String[] POSITION_DESCRIPTIONS = {"", ": Finished", ": First", ": Second", ": Third"};
    public static final int A_GRADE = 0;
    public static final int B_GRADE = 1;
    public static final int SENIOR = 2; 
    
    private String name;
    private int number;
    private int typeIndex;
    private int age;
    private int position;
    
    public Competitor(String name, int number, int typeIndex, int age) {
        this.name = name;
        this.number = number;
        this.typeIndex = typeIndex;
        this.age = age;
        this.position = -1;
    } 
    
    public String getName() { 
        return name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int getTypeIndex() {
        return typeIndex;
    }
    
    public int getAge() {
        return age;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
    
    public String toString() {
        String info = "" + number + ", " + name + " [" + COMPETITOR_DESCRIPTIONS[typeIndex] + "-"+ age + "]" + POSITION_DESCRIPTIONS[position+1];
        return info;
    }
}
