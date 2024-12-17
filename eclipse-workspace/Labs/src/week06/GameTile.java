package week06;

public class GameTile {

	private boolean isOccupied = false;
	private String tileValue;
	
	
	boolean getIsOccupied() {
		return isOccupied;
	}
	void setIsOccupied() {
		if (!this.isOccupied) {
			this.isOccupied = true;
		} else {
			this.isOccupied = false;
		}
	}
	
	String getTileValue() {
		return tileValue;
	}
	
	void setTileValue() {
		
	};
	
	String setTileValue(String input) {
		tileValue = input;
		return tileValue;
	}
	
}
