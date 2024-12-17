package week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	// instantiate 9 game squares
	// print game board to console
	// print updated game board to console after each turn
	
	// Constructor
	List<GameTile> gameBoard = new ArrayList<GameTile>();
	public List<GameTile> generateGameBoard() {
	
		for (int i = 0; i < 9; i++) {
			GameTile tile = new GameTile();
			StringBuilder sb = new StringBuilder();
			sb.append(i + 1);
			tile.setTileValue(sb.toString());
			gameBoard.add(tile);
		}
		
		return gameBoard;
	}
	
	public int getBoardSize() {
		return gameBoard.size();
	}
	
	public void printBoard() {
		System.out.print(String.format("+---+---+---+\n| 1 | 2 | 3 |\n+---+---+---+\n| 4 | 5 | 6 |\n+---+---+---+\n| 7 | 8 | 9 |\n+---+---+---+"));
		
	}
	
	public void getGameResult() {
		
	}
	
}
