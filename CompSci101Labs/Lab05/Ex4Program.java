
public class Ex4Program {

    public void start() {
        int[] cards = new int[52];
        System.out.println("Original Deck of Cards:");
        setUp(cards);
        printDeck(cards);
        System.out.println("\nShuffled Cards:");
        shuffle(cards);
        printDeck(cards);
    }
    
    private void setUp(int[] cards) {
        // complete this
        
    }
    
    private void shuffle(int[] cards) {
        // complete this method.
        
    }
    
    /*
     * Prints the deck of cards.
     */
    private void printDeck(int[] deck) {
        System.out.print("{ ");
        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i]);
            if (i != deck.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

}
