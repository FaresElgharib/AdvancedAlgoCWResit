package resitcw;

import java.util.Scanner;

public class Q8 {

	static class TicTacToe {
	    private static final int SIZE = 3;
	    private static final char EMPTY = ' ';
	    private static final char PLAYER_X = 'X';
	    private static final char PLAYER_O = 'O';

	    private char[][] board;
	    private char currentPlayer;

	    public TicTacToe() {
	        board = new char[SIZE][SIZE];
	        currentPlayer = PLAYER_X;

	        // initialize the board with empty cells
	        for (int i = 0; i < SIZE; i++) {
	            for (int j = 0; j < SIZE; j++) {
	                board[i][j] = EMPTY;
	            }
	        }
	    }

	    public void play() {
	        System.out.println("Welcome to Tic-Tac-Toe!");

	        while (true) {
	            displayBoard();
	            if (playerWin(PLAYER_X)) {
	                System.out.println("Player X wins");
	                break;
	            } else if (playerWin(PLAYER_O)) {
	                System.out.println("Player O wins");
	                break;
	            } else if (isBoardFull()) {
	                System.out.println("draw");
	                break;
	            }

	            if (currentPlayer == PLAYER_X) {
	                getUserMove();
	            }
	        }

	    }

	    private void displayBoard() {
	        System.out.println();
	        for (int i = 0; i < SIZE; i++) {
	            for (int j = 0; j < SIZE; j++) {
	                System.out.print(board[i][j]);
	                if (j < SIZE - 1) {
	                    System.out.print(" | ");
	                }
	            }
	            System.out.println();
	            if (i < SIZE - 1) {
	                System.out.println("---------");
	            }
	        }
	        System.out.println();
	    }

	    private void getUserMove() {
	        Scanner scanner = new Scanner(System.in);
	        int row, col;

	        while (true) {
	            System.out.print("Enter your move (row [1-3] column [1-3]): ");
	            row = scanner.nextInt() - 1;
	            col = scanner.nextInt() - 1;

	            if (isValidMove(row, col)) {
	                break;
	            } else {
	                System.out.println("Move not valid try again.");
	            }
	        }

	        board[row][col] = currentPlayer;
	    }

	    private boolean isValidMove(int row, int col) {
	        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
	            return false;
	        }
	        if (board[row][col] != EMPTY) {
	            return false;
	        }
	        return true;
	    }
    
	    private boolean playerWin(char player) {
	        // check rows
	        for (int i = 0; i < SIZE; i++) {
	            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
	                return true;
	            }
	        }

	        // check columns
	        for (int j = 0; j < SIZE; j++) {
	            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
	                return true;
	            }
	        }

	        // check diagonal
	        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
	            return true;
	        }
	        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
	            return true;
	        }

	        return false;
	    }

	    private boolean isBoardFull() {
	        for (int i = 0; i < SIZE; i++) {
	            for (int j = 0; j < SIZE; j++) {
	                if (board[i][j] == EMPTY) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        TicTacToe game = new TicTacToe();
	        game.play();
	    }
	}

}
