package week06Assignment.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import week06Assignment.Card;
import week06Assignment.Deck;
import week06Assignment.Player;

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
		deck.draw();
		assertEquals(51, Deck.cards.size());
	}
	
	@Test
	void playersFlipShouldRemoveOneCardFromHands() {
		Player player1 = new Player();
		Player player2 = new Player();
		Deck deck = new Deck();
		deck.generateNewDeck();
		for (int i = 26; i > 0; i--) {
			player1.draw(deck);
			player2.draw(deck);
		}
		player1.flip();
		player2.flip();
		// After both players have flipped a card, hand size should be decremented by 1
		assertTrue(player1.hand.size() < 26 && player2.hand.size() < 26);
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
