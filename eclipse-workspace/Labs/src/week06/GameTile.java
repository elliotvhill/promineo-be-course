package week06;

import java.util.HashMap;
import java.util.Map;

public class GameTile {

	// "X" tile = -1
	// "O" tile = 0

	static Map<Integer, HashMap<String, Boolean>> tiles = new HashMap<Integer, HashMap<String, Boolean>>();
	String tileValue;
	boolean isOccupied;
	int tileNumber;

	// Default constructor
	public GameTile(int tileValue, boolean isOccupied, int tileNumber) {
		this.tileValue = Integer.toString(tileValue);
		this.isOccupied = isOccupied;
		this.tileNumber = tileNumber;
	}

	boolean getIsOccupied() {
		return isOccupied;
	}

	void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	String setTileValue(GameTile tile) {
		return this.tileValue = tile.tileValue;
	};

}
