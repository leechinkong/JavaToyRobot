package com.lck.toyrobot;


/**
 * ToyRobot main class
 * 
 * @author lee
 *
 */
public class ToyRobot
{
	public static void main(String[] args)
	{
		// TODO
		System.out.println("===== Toy Robot Simulator =====");

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
						System.out.println(controller.report());
						break;
				}
			}
		}
	}
}
