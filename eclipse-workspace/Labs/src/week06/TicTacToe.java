package week06;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		char player1 = 'x';
		char player2 = 'o';
		Scanner input = new Scanner(System.in);
		
		// player1 (x) always starts
		// get (9) tiles
		// tiles are numbered 1-9
		// prompt user for input where to make a move
		// check for valid input
		// check rows for win
		// check columns for win
		// check diagonals for win
		// check for draw

		GameBoard board = new GameBoard();
		System.out.println(board.getBoardSize());
		board.printBoard();
		
	}

}
