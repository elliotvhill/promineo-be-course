package week06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameBoard {

	// 9 gameboard tiles/slots
	List<Map<String, Boolean>> gameTiles = new ArrayList<Map<String, Boolean>>();
	
	// Default constructor
	public GameBoard() {}

	
	// Methods
	private void generateGameBoard() {
		for (int i = 0; i < 9; i++) {
			// Generate a new tile with a value 1-9 (as a string) and isOccupied false
			GameTile tile = new GameTile(Integer.toString(i + 1), false);
		}
	}
	
}
