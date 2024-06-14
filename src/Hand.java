import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            switch (card.getRank()) {
                case "2": score += 2; break;
                case "3": score += 3; break;
                case "4": score += 4; break;
                case "5": score += 5; break;
                case "6": score += 6; break;
                case "7": score += 7; break;
                case "8": score += 8; break;
                case "9": score += 9; break;
                case "10":
                case "Jack":
                case "Queen":
                case "King":
                    score += 10;
                    break;
                case "Ace":
                    numAces++;
                    break;
            }
        }

        for (int i = 0; i < numAces; i++) {
            if (score + 11 <= 21) {
                score += 11;
            } else {
                score += 1;
            }
        }

        return score;
    }

    public void displayCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
