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
		System.out.println("Toy Robot Simulator");
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
						break;
					case MOVE:
						
						break;
					case LEFT:
						
						break;
					case RIGHT:
						
						break;
					case REPORT:
						
						break;
				}
			}
		}
	}
}
