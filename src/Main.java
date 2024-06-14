import java.util.Scanner;

public class Main {
    // Creating variables from the classes, so we can use them to play the game
    private static Deck deck;
    private static Hand player;
    private static Hand dealer;

    public static void main(String[] args) {
        // Initiating the variables
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
        Scanner input = new Scanner(System.in);

        // Asking the user if they wish to play
        System.out.println("Do you wish to play (yes or no): ");
        String play = input.nextLine();
        // Checking if the user wishes to play
        if ("yes".equalsIgnoreCase(play)) {
            // Creating a variable to start the game
            boolean gameOn = true;
            // Dealing the initial cards and displaying them. 2 for the player & 1 for the dealer
            dealStartCards();
            displayHands();
            // Printing the starting scores
            System.out.println("\nPlayer score: " + player.calculateScore());
            System.out.println("Dealer score: " + dealer.calculateScore());


            // Making sure that the game keeps on running using the while loop
            while (gameOn) {
                // checking if the player has won the game
                if (player.calculateScore() == 21) {
                    System.out.println("Player wins!!");
                } else {
                    // Asking the player if they wish to get another card or not
                    System.out.println("\nHit or Stand");
                    String newCard = input.nextLine();
                    if ("hit".equalsIgnoreCase(newCard)) {
                        playerHit();
                        // Checking if player has lost the game
                        if (player.calculateScore() > 21) {
                            System.out.println("Player loses");
                            gameOn = false; // Ending the game after determining weather the player has won or lost
                        }
                      // If player stands, the game will draw a card for the dealer
                    } else if ("stand".equalsIgnoreCase(newCard)) {
                        // Making sure the game continues until a winner has been determined
                        while (gameOn) {
                            dealerHit();
                            // Checking the dealer's score
                            if (dealer.calculateScore() > 21) {
                                System.out.println("Player Wins");
                                gameOn = false; // Ending the game after determining weather the player has won or lost
                            } else if (dealer.calculateScore() < 17) {
                                dealerHit();
                            } else if (dealer.calculateScore() == 21){
                                System.out.println("Player loses!");
                                gameOn = false; // Ending the game after determining weather the player has won or lost
                            } else {
                                // Determining the winner of the game
                                determineWinner();
                                System.out.println(determineWinner());
                                gameOn = false; // Ending the game after determining weather the player has won or lost
                            }
                        }
                    } else {
                        // Catching what the user enters if they did not enter "hit" or "stand"
                        System.out.println("Please enter hit or stand");
                    }
                }
            }
        } else if ("no".equalsIgnoreCase(play)) {
            System.out.println("Goodbye");
        } else {
            System.out.println("Please enter yes or no");
        }
    }

    public static void dealStartCards() {
        deck.shuffle();
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());

    }

    // Method for adding a card to the player's hand
    public static void playerHit() {
        player.addCard(deck.drawCard());
        displayHands();
        // Displaying the player and dealer scores
        System.out.println("\nPlayer score: " + player.calculateScore());
        System.out.println("Dealer score: " + dealer.calculateScore());
    }

    // Method that adds cards to the dealer's hand
    public static void dealerHit() {
        dealer.addCard(deck.drawCard());
        displayHands();
        // Printing the player and dealers scores
        System.out.println("\nPlayer score: " + player.calculateScore());
        System.out.println("Dealer score: " + dealer.calculateScore());
    }

    // Method for displaying the cards for the player and dealer
    public static void displayHands() {
        System.out.println("\nPlayer Hand: ");
        player.displayCards();
        System.out.println("\nDealer Hand: ");
        dealer.displayCards();
    }

    // A method that determines the winner
    public static String determineWinner() {
        // Creating variables to holds the scores for player and dealer
        int playerScore = player.calculateScore();
        int dealerScore = dealer.calculateScore();

        // Checking if player won or lost, or it's a tie
        if (playerScore > dealerScore) {
            return "Player Wins!!";
        } else if (playerScore == dealerScore) {
            return "It's a tie!";
        } else {
            return "Player loses!";
        }
    }

}