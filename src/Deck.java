import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // Creating an instance of the class which will be a list
    private List<Card> cards;

    // Initiating the class
    public Deck() {
        // Creating a new ArrayList to store the cards
        cards = new ArrayList<>();

        // Creating lists that hold the ranks and suits
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // Creating a dictionary with a suit as key and rank and value
        for (String suit : suits) {
            for (String rank : ranks) {
                // Adding the cards to the ArrayList
                cards.add(new Card(rank, suit));
            }
        }
    }

    // Shuffle method to shuttle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw a card
    public Card drawCard() {
        // Checking if the cards list is empty
        if (cards.isEmpty()) {
            // Returning an exception that states that the deck is empty
            throw new IllegalStateException("Deck is Empty");
        }
        // Removing and returning the card on the first position of the list
        return cards.remove(0);
    }
}
