package week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	public GameTile[] gameBoard = new GameTile[9];
	
	// Default constructor
	public void setStartingTiles() {
		// Set each tile value to 1-9 and isOccupied to false
		for (int i = 0; i < 9; i++) {
			gameBoard[i] = new GameTile(i + 1, false);
		}
	}
	
	// Get tile
	public GameTile getTile(int userInput) {
		GameTile foundTile;
		for (GameTile tile : gameBoard) {
			if (tile.tileValue.equals(Integer.toString(userInput))) {
				return foundTile = tile;
			} else {
				System.out.println("Tile not found.");
			}
		}
	}
	
	public void findAndUpdateGameTile(int userInput) {
		userInput -= 1;
		GameTile foundTile = gameBoard[userInput];
		gameBoard[userInput].setTileValue(foundTile); // sets tileValue to new value passed as string
	}

	// update and print game board to console after each turn
	public GameTile[] updateGameBoard(int tileNumber, String xOrO) {
		gameBoard[tileNumber].setTileValue(xOrO);
		gameBoard[tileNumber].setIsOccupied(true);
		
		System.out.println("+---+---+---+");
		for (GameTile tile : gameBoard) {
			System.out.print(String.format("| %s ", tile.tileValue.toString()));
		}
		System.out.println("+---+---+---+");
		
		return gameBoard;
	}
	
	// print NEW game board to console
	public void printNewBoard() {
		System.out.println("+---+---+---+");
		for (int i = 0; i < gameBoard.length - 1; i+=3) {
			System.out.print(String.format(
					"| %s | %s | %s |\n+---+---+---+\n", i + 1, i + 2, i + 3));
		}
	}

	public void getGameResult() {

	}

}
