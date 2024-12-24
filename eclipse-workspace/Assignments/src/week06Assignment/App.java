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

	}

}
