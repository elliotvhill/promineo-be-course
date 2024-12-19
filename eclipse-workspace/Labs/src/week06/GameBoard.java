package week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	static GameTile[] gameBoard = new GameTile[9];

	// Default constructor
	public void setGameBoard(GameTile tile) {
		// Set each tile value to 1-9 and isOccupied to false
		for (int i = 0; i < 9; i++) {
			gameBoard[i] = new GameTile(i + 1, false, i);
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
		for (int i = 0; i < 9; i++) {
			System.out.print(String.format("| %s ", gameBoard[i].tileValue));
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
