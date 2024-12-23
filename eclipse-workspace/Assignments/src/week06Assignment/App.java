package week06Assignment;

public class App {

	public static void main(String[] args) {

		Card testCard = new Card("Two", "Hearts", 2);
		testCard.describe();

		Player player1 = new Player("Geralt", 0);
		player1.describe();

		Deck deck = new Deck();
		deck.generateNewDeck();

	}

}
