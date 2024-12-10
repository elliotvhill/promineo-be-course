package week05;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<Card>();
	private static String[] cardNames = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Jack", "Queen", "King", "Ace" };

	// Constructor
	public Deck() {

		cards.addAll(createClubsCards());
		cards.addAll(createHeartsCards());
		cards.addAll(createSpadesCards());
		cards.addAll(createDiamondsCards());

	};

	public void describe() {
		Deck deck = new Deck();
		for (Card card : cards) {
			System.out.println(String.format("Card name: %-8s Suit: %-8s Value: %d", card.getName(), card.getSuit(),
					card.getValue()));
		}
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
