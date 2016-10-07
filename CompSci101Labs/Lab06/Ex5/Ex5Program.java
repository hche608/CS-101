public class Ex5Program {

    public void start() {
        BankAccount accountOne = new BankAccount("Holly Day", 551.49, 105682);
        BankAccount accountTwo = new BankAccount("Carrie Oakey", 45.28, 109835);
        BankAccount accountThree = new BankAccount("Bill Ding", 178.34, 759347);
        makeTransactions(accountOne, accountTwo, accountThree);
        printResults(accountOne, accountTwo, accountThree);
 
    }
    private void makeTransactions(BankAccount one, BankAccount two, BankAccount three) {
        one.deposit(20.00);
        two.withdraw(27.00);
        three.setBalance(3590.99);
        one.deposit(one.getBalance());
        one.setAccountName("Tom Katt"); 
    }
    
    private void printResults(BankAccount one, BankAccount two, BankAccount three) {
        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());
        System.out.println();
        if (three.hasABiggerBalanceThan(one) && three.hasABiggerBalanceThan(two)) {
            System.out.println(three.getAccountName() + " has a bigger account balance than " 
                                   + one.getAccountName() + " and " + two.getAccountName());
        } else if (two.hasABiggerBalanceThan(one) && two.hasABiggerBalanceThan(three)) {
            System.out.println(two.getAccountName() + " has a bigger account balance than " 
                                   + one.getAccountName() + " and " + three.getAccountName());
        } else if (one.hasABiggerBalanceThan(two) && one.hasABiggerBalanceThan(three)) {
            System.out.println(one.getAccountName() + " has a bigger account balance than " 
                                   + two.getAccountName() + " and " + three.getAccountName());
        }
    }
}
