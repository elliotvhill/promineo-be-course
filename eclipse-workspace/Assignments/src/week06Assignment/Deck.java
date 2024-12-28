package week06Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	static List<Card> cards = new ArrayList<Card>();

	private String[] cardNames = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
			"Queen", "King", "Ace" };
	private String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };

	// Constructor -- generate deck
	public List<Card> generateNewDeck() {
		// Generate cards of each suit
		for (String suit : suits) {
			// Generate cards of each name and value
			for (int i = 0; i < 13; i++) {
				Card cardToAdd = new Card(cardNames[i], suit, i + 2);
				cards.add(cardToAdd);
			}
		}
		return cards;
	}

	// Shuffle method
	public List<Card> shuffle() {
		Collections.shuffle(cards);
		return cards;
	}

	// Draw method
	public Card draw() {
		return cards.removeFirst();
	}

}
