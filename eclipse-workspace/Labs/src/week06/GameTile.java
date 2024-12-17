package week06;

import java.util.HashMap;
import java.util.Map;

public class GameTile {

	// "X" tile = -1
	// "O" tile = 0

	Map<Integer, Boolean> tiles = new HashMap<Integer, Boolean>();
	int tileValue;
	boolean isOccupied;

	void generateNewTile() {
		// initialize game tiles with values 1-9
		for (int i = 0; i < 9; i++) {
			this.tileValue = i + 1;
		}
		// set tiles to not occupied
		this.isOccupied = false;
	}

	boolean getIsOccupied() {
		return isOccupied;
	}

	void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	int getTileValue(GameTile tile) {
		return tile.tileValue;
	}

	// setTileValue can take an arg int for the initial value of each tile
	// (i.e. before they are occupied with either X or O
	void setTileValue(int num) {
		this.tileValue = num;
	};

	// set tile value to "X" or "O"
	void setTileValue(char xOrO) {
		this.tileValue = xOrO;
	}

}
