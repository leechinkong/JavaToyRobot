package com.lck.toyrobot;

import junit.framework.TestCase;

/**
 * Test for ToyRobotController
 * 
 * @author lee
 *
 */
public class ToyRobotControllerTest extends TestCase
{
	/**
	 * Test place method
	 */
	public void testPlace()
	{
		final ToyRobotController controller = new ToyRobotController();
		
		// all commands should be ignored until robot is placed
		controller.turn(Command.LEFT);
		controller.turn(Command.RIGHT);
		controller.move();
		assertNull("expect null value", controller.report());
		controller.place(0, 0, Face.NORTH);
		assertNotNull("expect not null value", controller.report());
		assertEquals("Output: 0,0,NORTH", controller.report());
		
		// invalid x and y, output unchanged
		controller.place(5, 5, Face.NORTH);
		assertEquals("Output: 0,0,NORTH", controller.report());
		controller.place(-1, -1, Face.NORTH);
		assertEquals("Output: 0,0,NORTH", controller.report());
		
		// valid x and y
		controller.place(3, 2, Face.SOUTH);
		assertEquals("Output: 3,2,SOUTH", controller.report());
		controller.place(1, 4, Face.WEST);
		assertEquals("Output: 1,4,WEST", controller.report());
	}
	
	/**
	 * Test move method
	 */
	public void testMove()
	{
		final ToyRobotController controller = new ToyRobotController();
		
		// move towards north
		controller.place(0, 0, Face.NORTH);
		controller.move();
		assertEquals("Output: 0,1,NORTH", controller.report());
		controller.place(4, 4, Face.NORTH);
		controller.move(); // invalid
		assertEquals("Output: 4,4,NORTH", controller.report());
		
		// move towards east
		controller.place(0, 0, Face.EAST);
		controller.move();
		assertEquals("Output: 1,0,EAST", controller.report());
		controller.place(4, 4, Face.EAST);
		controller.move(); // invalid
		assertEquals("Output: 4,4,EAST", controller.report());
		
		// move towards south
		controller.place(0, 0, Face.SOUTH);
		controller.move(); // invalid
		assertEquals("Output: 0,0,SOUTH", controller.report());
		controller.place(4, 4, Face.SOUTH);
		controller.move(); 
		assertEquals("Output: 4,3,SOUTH", controller.report());
		
		// move towards west
		controller.place(0, 0, Face.WEST);
		controller.move(); // invalid
		assertEquals("Output: 0,0,WEST", controller.report());
		controller.place(4, 4, Face.WEST);
		controller.move(); 
		assertEquals("Output: 3,4,WEST", controller.report());
	}
	
	/**
	 * Test turn method
	 */
	public void testTurn()
	{
		final ToyRobotController controller = new ToyRobotController();
		
		// sanity test, see FaceTest for detailed tests
		controller.place(0, 0, Face.NORTH);
		controller.turn(Command.LEFT);
		assertEquals("Output: 0,0,WEST", controller.report());
		controller.turn(Command.RIGHT);
		assertEquals("Output: 0,0,NORTH", controller.report());
	}
}
