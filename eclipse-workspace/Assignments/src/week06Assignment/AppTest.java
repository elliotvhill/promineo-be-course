package week06Assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void deckShouldHaveFiftyTwoCards() {
		Deck deck = new Deck();
		deck.generateNewDeck();
		assertTrue(Deck.cards.size() == 52);
	}

	@Test
	void drawShouldRemoveOneCardFromDeck() {
		Deck deck = new Deck();
		deck.generateNewDeck();
		deck.draw();
		assertFalse(Deck.cards.size() == 52);
	}
	
	@Test
	void playerShouldHaveTwentySixCards() {
		Player player1 = new Player();
		Player player2 = new Player();
		Deck deck = new Deck();
		deck.generateNewDeck();
		for (int i = 26; i > 0; i--) {
			player1.draw(deck);
			player2.draw(deck);
		}
		assertTrue(player1.getHand().size() == 26);
		assertTrue(player2.getHand().size() == 26);
	}
}
