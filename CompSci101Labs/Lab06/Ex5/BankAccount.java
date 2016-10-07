public class BankAccount {
    
    // Instance variables:
    
    // account name
    // balance 
    // account number
    private String accountName;
    private double amount;
    private int accountNumber;
    
    public BankAccount( String accountName, double amount, int accountNumber) {
        // constructor method to initialize the instance variables
        // Parameters are in the order: accountName, balance, accountNumber
        this.accountName = accountName;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public void setAccountName( String accountName) {
        this.accountName = accountName;
    }
    
    public double getBalance() {
        return amount;
    }
    
    public void setBalance( double amount) {
        this.amount = amount;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public boolean hasABiggerBalanceThan(BankAccount other) {
        return amount > other.amount;
    }
    
    public String toString() {
        // return a String representing the instance variables formatted as per the hand-out.
        String details = "";
        details += "Name: " + accountName + ", Account Number: " + accountNumber + ", Balance: $" + amount;
        return details;
        
    }
    
    public void deposit(double amount) {
        this.amount += amount;
    }
    
    public void withdraw(double amount) {
        this.amount -= amount;
    }
}

