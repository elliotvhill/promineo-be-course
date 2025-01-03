package week05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	// Create a List to store cards
	private static List<Card> cards = new ArrayList<Card>();
	private static Random random = new Random();

	private static String[] cardNames = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Jack", "Queen", "King", "Ace" };

	// Constructor
	public Deck() {

		// Add all cards of each suit to the deck
		cards.addAll(createClubsCards());
		cards.addAll(createHeartsCards());
		cards.addAll(createSpadesCards());
		cards.addAll(createDiamondsCards());

	};

	public void describe() {
		for (Card card : cards) {
			System.out.println(String.format("Card name: %-8s Suit: %-8s Value: %d", card.getName(), card.getSuit(),
					card.getValue()));
		}
	}

	public List<Card> shuffle() {
		Collections.shuffle(cards); // uses built-in Collections shuffle method
		return cards;
	}

	public Card draw() {
		// Get initial count of deck size to track when cards are drawn
		int deckSize = 0;
		for (Card card : cards) {
			deckSize++;
		}

		// Use Random object to pick a random index
		int randomIndex = random.nextInt(0, deckSize);
		Card cardDrawn = cards.get(randomIndex);
		// Make sure card is removed from the deck and that deck size is decremented
		cards.remove(randomIndex);
		deckSize--;
		return cardDrawn;
	}

	public List<Card> createClubsCards() {
		List<Card> clubs = new ArrayList<Card>();
		for (int i = 0; i < 13; i++) {
			Card card = new Card(cardNames[i], "Clubs", i + 2);
			clubs.add(card);
		}
		return clubs;
	};

	public List<Card> createHeartsCards() {
		List<Card> hearts = new ArrayList<Card>();
		for (int i = 0; i < 13; i++) {
			Card card = new Card(cardNames[i], "Hearts", i + 2);
			hearts.add(card);
		}
		return hearts;
	};

	public List<Card> createSpadesCards() {
		List<Card> spades = new ArrayList<Card>();
		for (int i = 0; i < 13; i++) {
			Card card = new Card(cardNames[i], "Spades", i + 2);
			spades.add(card);
		}
		return spades;
	};

	public List<Card> createDiamondsCards() {
		List<Card> diamonds = new ArrayList<Card>();
		for (int i = 0; i < 13; i++) {
			Card card = new Card(cardNames[i], "Diamonds", i + 2);
			diamonds.add(card);
		}
		return diamonds;
	};
}
