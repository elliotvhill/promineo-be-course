package week06Assignment;

import java.util.List;

public class Player {

	private String name;
	private List<Card> hand;
	private int score;
	
	// Constructor
	public Player(String name, List<Card> hand, int score) {
		this.name = name;
		this.hand = hand;
		this.score = 0;
	}
	
	public Player(String name, int score) {
		this.name = name;
		this.score = 0;
	}
	
	public void describe(){
		System.out.println(String.format("Player: %s\nScore: %d\nHand: ", name, score));
	}
	
//	flip(){}
//	
//	draw(){}
//	
//	incrementScore(){}
	
}
