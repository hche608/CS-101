/*
 * ============================
 *  UPI : HCHE608
 * ============================
 * CompSci 101 S2 2013
 * 
 * Class
 * Purpose: The Application for
 * a Date Class
 *
*/

public class MyDate {
    private int dayNumber;
    private int monthNumber;
    private int yearNumber;
    
    public MyDate(int d, int m, int y) {
        this.dayNumber = d;
        this.monthNumber = m;
        this.yearNumber = y;
    }
    public String toString() {  
        String dob = "" + dayNumber + "/" + monthNumber + "/" + yearNumber;
        return dob;
    }
}
