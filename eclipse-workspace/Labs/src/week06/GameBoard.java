package week06;

public class GameBoard {

	String[] gameBoard = new String[9];

	// Generate a new game board
	public void generateGameBoard() {
		for (int i = 0; i < 9; i++) {
			// Generate a new tile with a value 1-9
			this.gameBoard[i] = String.valueOf(i + 1);
		}
	}

	// Print game board to console
	public void printGameBoard() {
		System.out.println("+---+---+---+");
		for (int i = 0; i < gameBoard.length; i += 3) {
			System.out.print(String.format("| %s | %s | %s |\n+---+---+---+\n", gameBoard[i], gameBoard[i + 1],
					gameBoard[i + 2]));
		}
	}

	public String[] updateGameBoard(int tileToUpdate, String xOrO) {
		for (int i = 0; i < gameBoard.length; i++) {
			if (gameBoard[i].equals(String.valueOf(tileToUpdate))) {
				gameBoard[i] = xOrO;
				return gameBoard;
			}
		}
		return gameBoard;
	}
}
