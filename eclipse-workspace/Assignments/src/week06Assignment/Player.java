package week06Assignment;

import java.util.List;

public class Player {

	private String name;
	private List<Card> hand;
	private int score;
	
	// Initial constructor before player has drawn any cards
	public Player(String name, int score) {
		this.name = name;
		this.score = 0;
	}
	
	public Player(String name, List<Card> hand, int score) {
		this.name = name;
		this.hand = hand;
		this.score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void describe(){
		// TODO: add hand to describe print statement
		System.out.println(String.format("Player: %s\nScore: %d\nHand: ", name, score));
	}
	
//	Draw a card and add to player's hand
	public List<Card> draw(Deck deck){
		hand.add(deck.draw());
		return hand;
	}
	
	// Remove and return the top card in the hand
	public Card flip(List<Card> hand){
		Card flippedCard = ((Deck) hand).draw();
		hand.remove(flippedCard);
		return flippedCard;
	}
	
	// Increment player's score
	public int incrementScore(){
		return score++;
	}
	
}
