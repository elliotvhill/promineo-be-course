package week06;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

	GameTile[] gameBoard = new GameTile[9];
	

	// Constructor
	public GameTile[] generateNewGameBoard() {
		// set tiles to values 1-9
		for (int i = 0; i < 9; i++) {
			gameBoard[i].setTileValue(i + 1);
			gameBoard[i].isOccupied = false;
		}
		return gameBoard;
	}

	// update and print game board to console after each turn
	public GameTile[] updateGameBoard(int tileNumber, char xOrO) {
		gameBoard[tileNumber].setTileValue(xOrO);
		gameBoard[tileNumber].setIsOccupied(true);
		
//		System.out.println(gameBoard.toString());
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
