package com.ubs.connect_four.service;


/**
 * 
 * @author Rohit Agrawal 
 *
 */
public class PlayBoardImpl extends ModifiableBoard {
	private final int height;
	private final int width;
	private final char[][] board;
	public final char BORDER = '|';
	public final char EMPTY = ' ';

	public PlayBoardImpl(int height, int width) {
		this.height = height;
		this.width = width;
		this.board = createBoard();
	}
	
	private char[][] createBoard() {
		char[][] board = new char[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (col == 0 || col % 2 == 0)
					board[row][col] = BORDER;
				else
					board[row][col] = EMPTY;
			}
		}
		return board;
	}
	
	public void add(char dice, int column) {
		for (int row = height - 1; row >= 0; row--) {
			int counter = 1;
			for (int col = 1; col < width; col = col + 2) {
				if (column == counter) {
					if (board[row][col] != EMPTY) {
						break;
					}
					board[row][col] = dice;
					return;
				}
				counter++;
			}
		}
	}
	
	public String render() {
		StringBuilder builder = new StringBuilder();
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				builder.append(board[x][y]);
				if (y == width - 1)
					builder.append("\n");
			}
		}
		return builder.toString();
	}

	public char get(int row, int col) {
		if(this.board == null) {
			throw new RuntimeException("Board not created");
		}
		return board[row][col];
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}
	
}
