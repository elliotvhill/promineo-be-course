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

}
