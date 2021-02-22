package com.ubs.connect_four.service;


/**
 * 
 * @author Rohit Agrawal 
 *
 */
public abstract class ModifiableBoard implements PlayBoard {
	abstract public void add(char dice, int column);
}
