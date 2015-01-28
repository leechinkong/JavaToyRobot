package com.lck.toyrobot;

import java.util.Scanner;


/**
 * ToyRobot main class
 * 
 * @author lee
 *
 */
public class ToyRobot
{
	/** Special command for gracefully exit the program */
	private static final String QUIT = "QUIT";
	
	/**
	 * Program entry point.
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		System.out.println("===== Toy Robot Simulator =====");
		System.out.println("Enter commands to move the robot (enter QUIT to exit):");
		final ToyRobot toyRobot = new ToyRobot();
		
		// request input
		@SuppressWarnings("resource")
		final Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while(input != null && !QUIT.equalsIgnoreCase(input.trim()))
		{
			toyRobot.process(input);
			
			// continue to read input
			input = scanner.nextLine();
		}
	}
	
	/** Toy robot controller instance */
	private ToyRobotController controller;
	
	/**
	 * Construct toy robot main class
	 */
	public ToyRobot()
	{
		this.controller = new ToyRobotController();
	}

	/**
	 * Process input command string.
	 */
	public void process(String cmdStr)
	{
		Command cmd = null;
		if(cmdStr != null)
		{
			// to upper case
			// trim leading and trailing spaces
			cmdStr = cmdStr.toUpperCase().trim();
			
			// validate command
			cmd = Command.validate(cmdStr);
			if(cmd != null) 
			{
				switch (cmd)
				{
					case PLACE:
						// trim off the PLACE command
						final String placeArgs = cmdStr.substring(Command.PLACE.toString().length());
						// find out the x,y and face
						final String[] args = placeArgs.split(",");
						final int x = Integer.valueOf(args[0].trim());
						final int y = Integer.valueOf(args[1].trim());
						final Face face = Face.valueOf(args[2].trim());
						controller.place(x, y, face);
						break;
					case MOVE:
						controller.move();
						break;
					case LEFT:
						controller.turn(Command.LEFT);
						break;
					case RIGHT:
						controller.turn(Command.RIGHT);
						break;
					case REPORT:
						final String output = controller.report();
						if(output != null)
						{
							System.out.println(controller.report());
						}
						break;
				}
			}
		}
	}
}
