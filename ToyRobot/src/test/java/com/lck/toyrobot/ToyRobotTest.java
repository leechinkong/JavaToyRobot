package com.lck.toyrobot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for ToyRot
 * 
 * @author lee
 *
 */
public class ToyRobotTest extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ToyRobotTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(ToyRobotTest.class);
	}

	/**
	 * Main method test
	 */
	public void testMain()
	{
		// TODO
	}
	
	/** 
	 * Validate input commands.
	 */
	public void testValidate() 
	{
		final ToyRobot robot = new ToyRobot();
		
		// validate valid commands
		final String[] validCommands = {"PLACE 2,2,NORTH",
				"PLACE2,2,NORTH",
				"PLACE 2, 2, NORTH",
				"LEFT",
				"RIGHT",
				"MOVE",
				"REPORT"
		};
		
		for(String validCommand : validCommands) 
		{
			assertTrue(robot.validate(validCommand));
		}
		
		// validate invalid commands
		final String[] invalidCommands = {"PLACE",
				"PLACE 22,NORTH",
				"PLACE 2,2",
				"UNKNOWN",
				"RIGHT UKNOWN"
		};
		
		for(String validCommand : validCommands) 
		{
			assertFalse(robot.validate(validCommand));
		}
	}
}
