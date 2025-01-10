package week06Assignment;

public class Card {

	private String name;
	private String suit;
	private int value;
	
	// Default constructor
	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}
	
	public Card() {}

	// Getters
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void describe() {
		System.out.println(String.format("%s (%d) of %s", name, value, suit));
	}
	
}
