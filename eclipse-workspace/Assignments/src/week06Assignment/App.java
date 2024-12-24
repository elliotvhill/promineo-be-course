package week06Assignment;

public class App {

	static Deck deck = new Deck();
	
	public static void main(String[] args) {
		
		// Generate and shuffle new card deck
		deck.generateNewDeck();
		deck.shuffle();

		// Create players
		Player player1 = new Player("Geralt", 0);
		player1.describe();
		
		Player player2 = new Player("Dandelion", 0);
		player2.describe();

		// Draw and deal cards to player1's hand
		for (int i = 26; i > 0; i--) {
			player1.draw(deck);
		}
		
		// Deal remaining cards to player2's hand
		while (deck.getDeckSize() >= 0) {
			player2.hand.add(deck.draw());
		}
		
	}

}
