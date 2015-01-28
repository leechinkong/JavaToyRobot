package com.lck.toyrobot;

import junit.framework.TestCase;

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
	}
}
