package com.ubs.connect_four.service;


/**
 * 
 * @author Rohit Agrawal 
 *
 */
public class WinnerOnFour implements Winner {
	
	private final PlayBoard board;
	private final int height;
	private final int width;
	
	public WinnerOnFour(PlayBoard board) {
		if(board == null)
			throw new RuntimeException("Board is not created");
		this.board = board;
		this.height = board.getHeight();
		this.width = board.getWidth();
	}
	
	private boolean horizontal(char currPlayer) {
		for(int row = height-1; row >= 0; row--) {
			for(int col = 1; col < width-7; col = col+2) {
				if(board.get(row, col) == currPlayer &&
						board.get(row, col+2) == currPlayer && 
						board.get(row, col+4) == currPlayer &&
						board.get(row, col+6) == currPlayer) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean vertical(char currPlayer) {
		for(int row = 0; row < height-3; row ++) {
			for(int col = 1; col < width; col = col+2) {
				if(board.get(row, col) == currPlayer &&
						board.get(row + 1, col) == currPlayer && 
						board.get(row + 2, col) == currPlayer &&
						board.get(row + 3, col) == currPlayer)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean diagonalTopToDown(char currPlayer) {
		for(int row = 0; row < height-3; row ++) {
			for(int col = 1; col < width-7; col = col+2) {
				if(board.get(row, col) == currPlayer &&
						board.get(row+1, col+2) == currPlayer && 
						board.get(row+2, col+4) == currPlayer &&
						board.get(row+3, col+6) == currPlayer)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean diagonalBottomToUp(char currPlayer) {
		for(int row = 3; row < height; row ++) {
			for(int col = 1; col < width-7; col = col+2) {
				if(board.get(row, col) == currPlayer &&
						board.get(row-1, col+2) == currPlayer && 
						board.get(row-2, col+4) == currPlayer &&
						board.get(row-3, col+6) == currPlayer) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isWinner(char currPlayer) {
		return horizontal(currPlayer) || vertical(currPlayer) || diagonalBottomToUp(currPlayer)
				|| diagonalTopToDown(currPlayer);
	}
}
