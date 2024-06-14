public class Card {

    // Class instances
    private String rank;
    private String suit;

    // Initiating the class
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Get methods for the card
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    // ToString get method to return the rank and suit of the card
    public String toString() {
        return rank + " of " + suit;
    }
}
