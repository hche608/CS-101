public class Ex01Program {
    public void start() {
        int luckyNumber1 = (int)(Math.random()*6+25);
        int luckyNumber2 = (int)(Math.random()*6+25);
        int largestNumber = Math.max(luckyNumber1,luckyNumber2);
        int smallestNumber = Math.min(luckyNumber1,luckyNumber2);
        System.out.println("Your lucky numbers " + largestNumber + " and " + smallestNumber);
    }
}
