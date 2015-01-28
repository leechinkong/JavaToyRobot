package com.lck.toyrobot;

import junit.framework.TestCase;

/**
 * Test for Face class
 * 
 * @author lee
 *
 */
public class FaceTest extends TestCase
{
	/**
	 * Test method for turn
	 */
	public void testTurn()
	{
		assertEquals(Face.WEST, Face.NORTH.turn(Command.LEFT));
		assertEquals(Face.NORTH, Face.EAST.turn(Command.LEFT));
		assertEquals(Face.EAST, Face.SOUTH.turn(Command.LEFT));
		assertEquals(Face.SOUTH, Face.WEST.turn(Command.LEFT));
		
		assertEquals(Face.EAST, Face.NORTH.turn(Command.RIGHT));
		assertEquals(Face.SOUTH, Face.EAST.turn(Command.RIGHT));
		assertEquals(Face.WEST, Face.SOUTH.turn(Command.RIGHT));
		assertEquals(Face.NORTH, Face.WEST.turn(Command.RIGHT));
	}
}
