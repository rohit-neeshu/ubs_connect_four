package com.ubs.connect_four.service;

import com.ubs.connect_four.exception.InvalidMoveException;


/**
 * 
 * @author Rohit Agrawal 
 *
 */
public class ConnectFourImpl extends ConnectFour {

	private ModifiableBoard board;
	private final char player_1 = 'R';
	private final char player_2 = 'G';
	private Winner winnerImpl;

	public ConnectFourImpl(int height, int width) {
		this.board = new PlayBoardImpl(height, width);
		this.winnerImpl = new WinnerOnFour(board);
	}
	
	@Override
	public void nextTurn() {
		if(currPlayer == PlayBoard.EMPTY)
			currPlayer = player_1;
		else if (currPlayer == player_1)
			currPlayer = player_2;
		else
			currPlayer = player_1;
	}

	@Override
	public boolean nextMove(int column) throws InvalidMoveException {
		isValidMove(column);
		this.board.add(currPlayer, column);
		return true;
	}

	@Override
	public boolean isWinner() {
		return winnerImpl.isWinner(currPlayer);
	}
	
	@Override
	public String render() {
		return this.board.render();
	}
	
	private boolean isValidMove(int column) throws InvalidMoveException {
		if (column < 1 || column > 7 ) {
			throw new InvalidMoveException("Column value must be between 1 to 7");
		}
		
		int counter = 1;
		int width = board.getWidth();
		for(int col = 1; col < width; col = col + 2) {
			if(column == counter) {
				if(board.get(0, col) != PlayBoard.EMPTY) {
					throw new InvalidMoveException(column + " is full. Please choose another column");
				}		
			}
			counter++;
		}
		return true;
	}

}
