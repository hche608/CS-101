public class Ex10Program {
    public void start() {
        System.out.print("Principal? ");
        double principal = Double.parseDouble(Keyboard.readInput());
        System.out.print("Rate? ");
        double rate = Double.parseDouble(Keyboard.readInput());
        System.out.print("Years? ");
        int years = Integer.parseInt(Keyboard.readInput());
        int amount = (int)Math.round(principal*Math.pow((1+rate/100),years));
        System.out.println("Amount at the end of " + years + "years: $" + amount);
    }
}
