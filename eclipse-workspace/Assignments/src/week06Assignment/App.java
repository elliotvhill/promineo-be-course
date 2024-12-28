package week06Assignment;

public class App {

	static Deck deck = new Deck();

	public static void main(String[] args) {

		// Generate and shuffle new card deck
		deck.generateNewDeck();
		deck.shuffle();

		// Create players
		Player player1 = new Player("Geralt", 0);
		Player player2 = new Player("Dandelion", 0);

		// Deal cards to players
		for (int i = 26; i > 0; i--) {
			player1.draw(deck);
			player2.draw(deck);
		}

		// Players take turns flipping cards
		Card player1Card = player1.flip();
		Card player2Card = player2.flip();
		if (player1Card.getValue() > player2Card.getValue()) {
			player1.incrementScore();
			System.out.println("Player 1 wins the round.");
		} else if (player2Card.getValue() > player1Card.getValue()) {
			player2.incrementScore();
			System.out.println("Player 2 wins the round.");
		}

		System.out.println("Player 1 score: " + player1.getScore());
		System.out.println("Player 2 score: " + player2.getScore());
	}

}
