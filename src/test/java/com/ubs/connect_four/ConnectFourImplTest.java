package com.ubs.connect_four;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.connect_four.exception.InvalidMoveException;
import com.ubs.connect_four.service.ConnectFour;
import com.ubs.connect_four.service.ConnectFourImpl;

public class ConnectFourImplTest {

	ConnectFour connectFour = null;
	
	@Before
    public void setUp() throws Exception {
		connectFour = new ConnectFourImpl(6, 15);
    }
	
	@Test
	public void testNextTurn() {
		connectFour.nextTurn();
		Assert.assertEquals('R', connectFour.getCurrentPlayer());
		
	}
	
	@Test
	public void testNextTurn1() {
		connectFour.nextTurn();
		connectFour.nextTurn();
		Assert.assertEquals('G', connectFour.getCurrentPlayer());
		
	}
	
	@Test
	public void testNextMove() throws InvalidMoveException  {
		Assert.assertTrue(connectFour.nextMove(1));
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testNextMove1() throws InvalidMoveException  {
		connectFour.nextMove(10);
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testNextMove2() throws InvalidMoveException  {
		connectFour.nextMove(0);
	}
	
	@Test(expected = InvalidMoveException.class)
	public void testNextMove3() throws InvalidMoveException  {
		connectFour.nextTurn();
		connectFour.nextMove(1);//1
		connectFour.nextTurn();
		connectFour.nextMove(1);//2
		connectFour.nextTurn();
		connectFour.nextMove(1);//3
		connectFour.nextTurn();
		connectFour.nextMove(1);//4
		connectFour.nextTurn();
		connectFour.nextMove(1);//5
		connectFour.nextTurn();
		connectFour.nextMove(1);//6
		connectFour.nextTurn();
		connectFour.nextMove(1);//7
	}
	
	@Test
	public void testWinnerVertical() throws InvalidMoveException  {
		connectFour.nextTurn();
		connectFour.nextMove(1);//1
		connectFour.nextMove(1);//2
		connectFour.nextMove(1);//3
		connectFour.nextMove(1);//4
		Assert.assertTrue(connectFour.isWinner());
	}
	
	@Test
	public void testWinner1() throws InvalidMoveException  {
		connectFour.nextTurn();
		connectFour.nextMove(1);//1
		connectFour.nextMove(1);//2
		connectFour.nextMove(1);//3
		Assert.assertFalse(connectFour.isWinner());
	}
	
	@Test
	public void testWinnerHorizontal() throws InvalidMoveException  {
		connectFour.nextTurn();
		connectFour.nextMove(1);//1
		connectFour.nextMove(2);//2
		connectFour.nextMove(3);//3
		Assert.assertFalse(connectFour.isWinner());
	}
	
	@Test
	public void testWinnerHorizontal1() throws InvalidMoveException  {
		connectFour.nextTurn();
		connectFour.nextMove(1);//1
		connectFour.nextMove(2);//2
		connectFour.nextMove(3);//3
		connectFour.nextMove(3);//4
		Assert.assertFalse(connectFour.isWinner());
	}
	
	@Test
	public void testWinnerDiagonal() throws InvalidMoveException  {
		connectFour.nextTurn();//r
		connectFour.nextMove(1);
		connectFour.nextTurn();//g
		connectFour.nextMove(2);
		connectFour.nextTurn();//r
		connectFour.nextMove(3);
		connectFour.nextTurn();//g
		connectFour.nextMove(4);
		connectFour.nextTurn();//r
		connectFour.nextMove(2);
		connectFour.nextTurn();//g
		connectFour.nextMove(3);
		connectFour.nextTurn();//r
		connectFour.nextMove(3);
		connectFour.nextTurn();//g
		connectFour.nextMove(4);
		connectFour.nextTurn();//r
		connectFour.nextMove(4);
		connectFour.nextTurn();//g
		connectFour.nextMove(5);
		connectFour.nextTurn();//r
		connectFour.nextMove(4);
		//System.out.println(connectFour.render());
		Assert.assertTrue(connectFour.isWinner());
	}
	
	@Test
	public void testRender() throws InvalidMoveException  {
		StringBuilder builder = new StringBuilder();
		builder.append("| | | | | | | |\n");
		builder.append("| | | | | | | |\n");
		builder.append("| | | |R| | | |\n");
		builder.append("| | |R|R| | | |\n");
		builder.append("| |R|G|G| | | |\n");
		builder.append("|R|G|R|G|G| | |\n");
		
		connectFour.nextTurn();//r
		connectFour.nextMove(1);
		connectFour.nextTurn();//g
		connectFour.nextMove(2);
		connectFour.nextTurn();//r
		connectFour.nextMove(3);
		connectFour.nextTurn();//g
		connectFour.nextMove(4);
		connectFour.nextTurn();//r
		connectFour.nextMove(2);
		connectFour.nextTurn();//g
		connectFour.nextMove(3);
		connectFour.nextTurn();//r
		connectFour.nextMove(3);
		connectFour.nextTurn();//g
		connectFour.nextMove(4);
		connectFour.nextTurn();//r
		connectFour.nextMove(4);
		connectFour.nextTurn();//g
		connectFour.nextMove(5);
		connectFour.nextTurn();//r
		connectFour.nextMove(4);
		
		Assert.assertEquals(builder.toString(), connectFour.render());
	}
	
}
