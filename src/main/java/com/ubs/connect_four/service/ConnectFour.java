package com.ubs.connect_four.service;

import com.ubs.connect_four.exception.InvalidMoveException;

public abstract class ConnectFour {
	
	char currPlayer = PlayBoard.EMPTY;
	abstract public boolean nextMove(int column) throws InvalidMoveException;
	abstract public boolean isWinner(); 
	abstract public void nextTurn();
	abstract public String render();
	
	public char getCurrentPlayer() {
		return this.currPlayer;
	}
}
