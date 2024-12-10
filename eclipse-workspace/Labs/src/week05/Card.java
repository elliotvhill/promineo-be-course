package week05;

public class Card {

	private String name, suit;
	private int value;
	
	// Constructor
	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}
	
	// Describe method
	public void describe() {
		System.out.println(String.format("Card name: %-8s Suit: %-8s Value: %d", name, suit, value));
	}
	
	// Getters & setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
