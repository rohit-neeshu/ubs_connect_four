package com.ubs.connect_four.service;

public interface PlayBoard {
	char EMPTY = ' ';
	char get(int row, int col);
	String render();
	int getHeight();
	int getWidth();
}
