package week06Assignment;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;

	// Default constructor
	public Player() {}
	
	// Initial constructor before player has drawn any cards
	public Player(String name, int score) {
		this.name = name;
		this.score = 0;
	}

	// Constructor -- initializes score to 0 to start
	public Player(List<Card> hand, String name) {
		this.hand = hand;
		this.score = 0;
		this.name = name;
	}

	// Getters & Setters

	public String getName() {
		return name;
	}

	public void setName(String playerName) {
		name = playerName;
	}

	public int getScore() {
		return score;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> playerHand) {
		hand = playerHand;
	}

	// Describe method
	public void describe() {
		// If player has been dealt cards
		if (hand.size() != 0) {
			System.out.println(String.format("\nPlayer: %s\n Score: %d\n Hand:\n", name, score));
			for (Card card : hand) {
				card.describe();
			}
		} else {
			// Player doesn't have any cards
			System.out.println(String.format("\nPlayer: %s\n Score: %d", name, score));
		}
	}

	// Flip method -- return and remove first card in player's hand
	public Card flip() {
		return hand.removeFirst();
	}

	// Draw method -- draw card from deck and add to player's hand
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}

	// Increment score method
	public int incrementScore() {
		return score++;
	}

}
