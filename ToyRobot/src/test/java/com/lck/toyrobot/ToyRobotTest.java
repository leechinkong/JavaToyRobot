package com.lck.toyrobot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import junit.framework.TestCase;


public class ToyRobotTest extends TestCase
{	
	/** 
	 * Test for processing input commands.
	 * @throws Exception any io exception 
	 */
	public void testProcess() throws IOException 
	{
		String[] commands1 = {"PLACE 0,0,NORTH",
		"MOVE",
		"REPORT"}; //0,1,NORTH
		testProcess(commands1, "Output: 0,1,NORTH");

		String[] commands2 = {"PLACE 3,2,NORTH",
		"MOVE",
		"REPORT"}; //3,3,NORTH
		testProcess(commands2, "Output: 3,3,NORTH");
		
		String[] commands3 = {"PLACE 1,4,WEST",
		"MOVE",
		"MOVE",
		"MOVE",
		"LEFT",
		"RIGHT",
		"MOVE",
		"REPORT"}; //0,4,WEST
		testProcess(commands3, "Output: 0,4,WEST");
		
		String[] commands4 = {"PLACE 2,2,SOUTH",
		"RIGHT",
		"MOVE",
		"LEFT",
		"MOVE",
		"REPORT"}; //1,1,SOUTH
		testProcess(commands4, "Output: 1,1,SOUTH");
		
		String[] commands5 = {"PLACE 0,4,NORTH",
		"RIGHT",
		"MOVE",
		"MOVE",
		"MOVE",
		"RIGHT",
		"MOVE",
		"LEFT",
		"MOVE",
		"RIGHT",
		"MOVE",
		"LEFT",
		"LEFT",
		"REPORT"}; //4,2,NORTH
		testProcess(commands5, "Output: 4,2,NORTH");
		
		String[] commands6 = {"PLACE 4,4,EAST",
		"LEFT",
		"RIGHT",
		"LEFT",
		"LEFT",
		"MOVE",
		"MOVE",
		"RIGHT",
		"MOVE",
		"RIGHT",
		"MOVE",
		"RIGHT",
		"MOVE",
		"MOVE",
		"MOVE",
		"LEFT",
		"MOVE",
		"REPORT"}; //4,1,EAST
		testProcess(commands6, "Output: 4,1,EAST");
	}
	
	/**
	 * Helper method to test a list of commands
	 * @param commands the commands to test
	 * @param expected the expect output
	 * @throws IOException any io exception
	 */
	public void testProcess(String[] commands, String expected) throws IOException
	{
		// redirect stdout 
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(os));
	    
		final ToyRobot toyRobot = new ToyRobot();
		for(String command : commands)
		{
			toyRobot.process(command);
		}
		assertEquals(expected, os.toString().trim());
		
		// close stream
		os.close();
		System.setOut(null);
	}
}
