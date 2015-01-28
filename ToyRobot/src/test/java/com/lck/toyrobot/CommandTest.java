package com.lck.toyrobot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Command class
 * 
 * @author lee
 *
 */
public class CommandTest extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CommandTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(CommandTest.class);
	}
	
	/** 
	 * Test for validating input commands.
	 */
	public void testValidate() 
	{
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
			assertNotNull("expect valid command: " + validCommand, Command.validate(validCommand));
		}
		
		// validate invalid commands
		final String[] invalidCommands = {"PLACE",
				"PLACE 22,NORTH",
				"PLACE 2,2",
				"UNKNOWN",
				"RIGHT UKNOWN"
		};
		
		for(String invalidCommand : invalidCommands) 
		{
			assertNull("expect invalid command: " + invalidCommand, Command.validate(invalidCommand));
		}
	}
}