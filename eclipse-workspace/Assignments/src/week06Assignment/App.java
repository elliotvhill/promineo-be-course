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

		// While players' hands are not empty
		for (int i = 52; i >= 0; i--) {
			while (player1.getHand().size() != 0 && player2.getHand().size() != 0) {
				// Players take turns flipping cards
				Card player1Card = player1.flip();
				System.out.print(player1.getName() + " draws: ");
				player1Card.describe();

				Card player2Card = player2.flip();
				System.out.print(player2.getName() + " draws: ");
				player2Card.describe();
				System.out.println();

				if (player1Card.getValue() > player2Card.getValue()) {
					player1.incrementScore();
					System.out.println(player1.getName() + " wins the round.");
					System.out.println();

				} else if (player2Card.getValue() > player1Card.getValue()) {
					player2.incrementScore();
					System.out.println(player2.getName() + " wins the round.");
					System.out.println();

				} else {
					System.out.println("It's a draw!\n");
				}

				System.out.println(player1.getName() + "'s score: " + player1.getScore());
				System.out.println(player2.getName() + "'s score: " + player2.getScore() + "\n");
			}
		}

		System.out.println(String.format("-------------\nFinal Scores\n%s: %d\n%s: %d\n", player1.getName(),
				player1.getScore(), player2.getName(), player2.getScore()));
		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " wins!");
		} else if (player2.getScore() > player1.getScore()) {
			System.out.println(player2.getName() + " wins!");
		} else {
			System.out.println("No one wins -- it's a tie!");
		}
	}

}
