package com.lck.toyrobot;

import junit.framework.TestCase;

/**
 * Unit test for Command class
 * 
 * @author lee
 *
 */
public class CommandTest extends TestCase
{	
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
