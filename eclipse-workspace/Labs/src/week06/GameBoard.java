package week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	static GameTile[] gameBoard;

	// Default constructor
	public void gameBoard(GameTile tile) {
		for (int i = 0; i < 9; i++) {
			tile.tileNumber = i + 1;
			tile.isOccupied = false;
			tile.tileValue = null;
		}
	};
	
	// Get tile
	public GameTile findTile(int userInput) {
		GameTile foundTile = gameBoard[userInput - 1];
		return foundTile;
	}
	
	// Update game tile
	public void updateGameTile(int index, String xOrO) {
		gameBoard[index].tileValue = xOrO;
		gameBoard[index].isOccupied = true;
	}

	// Print game board to console
	public void printBoard() {
		System.out.println("+---+---+---+");
		for (GameTile tile : gameBoard) {
			System.out.print(String.format("| %s ", tile.tileValue));
		}
		System.out.println("+---+---+---+");
	}
	
	// print NEW game board to console
//	public void printNewBoard() {
//		System.out.println("+---+---+---+");
//		for (int i = 0; i < gameBoard.length - 1; i+=3) {
//			System.out.print(String.format(
//					"| %s | %s | %s |\n+---+---+---+\n", i + 1, i + 2, i + 3));
//		}
//	}

	public void getGameResult() {

	}

}
