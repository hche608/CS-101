/*
 * Lab 3 Exercise 2
 * Program truncates to 1dp an amount entered by the user
 * Author:
 * Date Written:
 */

 public class Ex2Program {
     public void start() {
         double amount = getAmountFromUser();
         String truncatedAmount = truncateTo1DP(amount);
         printTruncatedAmount(truncatedAmount);
     }

}
