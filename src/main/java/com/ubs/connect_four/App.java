package com.ubs.connect_four;

import java.util.Scanner;

import com.ubs.connect_four.exception.InvalidMoveException;
import com.ubs.connect_four.service.ConnectFour;
import com.ubs.connect_four.service.ConnectFourImpl;
import com.ubs.connect_four.util.Util;

/**
 * 
 * @author Rohit Agrawal 
 *
 */
public class App {
	public boolean winner = false;
	
	ConnectFour connectFour;
	
	public App() {
		connectFour = new ConnectFourImpl(6,15);
	}
	
	public static void main(String[] args) {
		guide();
		App game;
		Scanner sc = new Scanner(System.in);
		while(true) {
			game = new App();
			game.startGame(sc);
			boolean restart = game.restartGame(sc);
			if(!restart)
				game.quit(sc);
		}
	}
	
	public static void guide() {
		System.out.println("Connect-Four");
		System.out.println("# Two players allowed to play the game");
		System.out.println("# Player 1 dice is R and Player 2 dice is G");
		System.out.println("# Each player will be allowed to enter the column value between 1 to 7");
		System.out.println("# Any player have continuous 4 values in the board either horizontally or vertically or diagonally will be the winner");
		System.out.println("| | | | | | | |\n" +
		"| | |G|G| | | |\n" +
		"| |R|G|R| | | |\n" +
		"| |G|R|R| | | |\n" +
		"|G|G|R|G| | | |\n" +
		"|R|G|R|R| | | |");
		System.out.println("# In the above sample, Player G is the winner");
		System.out.println("# User can quit the game in between by pressing Q");
		System.out.println("");
		System.out.println("");
		System.out.println("**** Lets play the game *****");
		System.out.println("");
		System.out.println("");
	}
	
	public void startGame(Scanner sc) {
		boolean isQuit = false;
		int turn = 1;
		while(!winner && turn <= 42) { 
			boolean validPlay = false;
			int column = 1;
			
			connectFour.nextTurn();
			while (!validPlay) {
				String line;
				String[] inputs = null;
				try {
					if (isQuit) {
						line = sc.nextLine().trim();
						isQuit = Util.yesOrNo(line);
						if(isQuit)
							quit(sc);
					} else {
						System.out.println(connectFour.render());
						System.out.println("Player " + connectFour.getCurrentPlayer() + ", choose column : ");
						line = sc.nextLine().trim();
						inputs = line.split(" ");

						if (inputs.length > 1)
							throw new IllegalArgumentException();
						column = Integer.parseInt(inputs[0]);
						validPlay = connectFour.nextMove(column);
					}
				} catch (NumberFormatException e) {
					if ("Q".equalsIgnoreCase(inputs[0])) {
						System.out.println("Do you want to quit the game ? y/n : ");
						isQuit = true;
					}
					else
						System.err.println("Please enter a valid number between 1 to 7");
				}
				catch (InvalidMoveException e) {
					System.err.println(e.getMessage());
					validPlay = false;
				}
				catch (Exception e) {
					System.err.println("Please enter a valid input");
				}
			}
			winner = connectFour.isWinner();
			turn++;
		}
		System.out.println(connectFour.render());
		if(winner) {
			System.out.println(connectFour.getCurrentPlayer() + " player won" );
		}
		else {
			System.out.println("Tie Game");
		}
	}
	
	
	public void quit(Scanner sc) {
		sc.close();
		System.out.println("Exit");
		System.exit(0);
	}
	
	
	public boolean restartGame(Scanner sc) {
		System.out.println("Do you want to restart the game ? y:n ");
		while (true) {
			String line = sc.nextLine();
			try {
				return Util.yesOrNo(line);
			}
			catch(Exception e) {
				System.err.println("Please enter valid input");
			}
		}
	}
	
}
