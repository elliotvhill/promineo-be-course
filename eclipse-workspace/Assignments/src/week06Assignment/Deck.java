package week06Assignment;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	public List<Card> cards = new ArrayList<Card>();
	private String[] cardNames = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
			"Queen", "King", "Ace" };
	private String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };

	public List<Card> generateNewDeck() {
		// Generate cards of each suit
		for (String suit : suits) {
			// Generate cards of each name and value
			for (int i = 0; i < 13; i++) {
				Card cardToAddToDeck = new Card(cardNames[i], suit, i + 2);
				cards.add(cardToAddToDeck);
				System.out.println(String.format("Card added: %s of %s, value: %d", cardToAddToDeck.getName(),
						cardToAddToDeck.getSuit(), cardToAddToDeck.getValue()));
			}
		}
		System.out.println("Deck size: " + cards.size());
		return cards;
	}

	// shuffle method
	// draw method

}
