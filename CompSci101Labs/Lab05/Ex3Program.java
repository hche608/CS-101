
public class Ex3Program {

    public void start() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        String month = askUserForMonth();
        while (! validMonth(month, monthNames)) {
            month = askUserForMonth();
        }
        
        printNumberOfDaysInMonth(month, monthNames, daysInMonth);
    }
    
    private String askUserForMonth() {
        System.out.print("Enter the month: ");
        String monthName = Keyboard.readInput();
        return monthName;
    }
    
    private boolean validMonth (String month, String[] monthNames) {
        int monthNumber = findMonthNumber(month, monthNames);
        if (monthNumber == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    private void printNumberOfDaysInMonth(String month, String[] monthNames, int[] daysInMonth) {
        int i = findMonthNumber(month, monthNames);
                System.out.println("There are "+daysInMonth[i]+" days in "+month);
            }
       
        
        // call the findMonthNumber() method to obtain the appropriate index into the daysInMonth array.
        
        // print the number of days from the appropriate element in the daysInMonth array.
    
    
    private int findMonthNumber (String month, String[] monthNames) {
        
        for(int i=0;i<monthNames.length;i++){
            
            if(month.equals(monthNames[i])){
                return i;
            }
        }
        return -1;
               
    }
}
        
        
        
        // Loop through the array searching for the corresponding month.
        
        // Return the index of the matching month name.
        
        // If the month cannot be found in the monthNames array, return -1.


