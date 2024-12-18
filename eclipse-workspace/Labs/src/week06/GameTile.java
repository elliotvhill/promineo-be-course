package week06;

import java.util.HashMap;
import java.util.Map;

public class GameTile {

	// "X" tile = -1
	// "O" tile = 0

	Map<Integer, Boolean> tiles = new HashMap<Integer, Boolean>();
	String tileValue;
	boolean isOccupied;

	// Default constructor
	public GameTile(String tileValue) {
		// Set initial tile value (1-9) as string
		this.tileValue = tileValue;
		// Set tile to not occupied
		this.isOccupied = false;
	}

	boolean getIsOccupied() {
		return isOccupied;
	}

	void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

//	GameTile getTile(int userInput) {
//		return GameBoard.get();
//	}

	String setTileValue(GameTile tile) {
		this.tileValue = tile.tileValue;
		return this.tileValue.toString();
	};

}
