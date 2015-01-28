package com.lck.toyrobot;

public enum Command
{
	PLACE("PLACE"),
	MOVE("MOVE"),
	LEFT("LEFT"),
	RIGHT("RIGHT"),
	REPORT("REPORT");
	
	private String command;
	private Command(String command) 
	{
		this.command = command;
	}
	
	@Override
	public String toString()
	{
		return command;
	}
	
	/**
	 * Validate the input command.
	 * @param command the input command string.
	 * @return the valid command enum object, if valid.
	 */
	public static Command validate(String command) 
	{
		Command cmd = null;
		if(command != null) 
		{
			if(command.startsWith(PLACE.command)) 
			{
				if(command.matches(PLACE.command + 
						"\\s*\\d+\\s*,\\s*\\d+\\s*,\\s*(" + 
						Face.NORTH + "|" +
						Face.EAST + "|" +
						Face.SOUTH + "|" +
						Face.WEST + ")"))
				{
					cmd = PLACE;
				}
			} 
			else if(command.equals(MOVE.command)) 
			{
				cmd = MOVE;
			}
			else if(command.equals(LEFT.command)) 
			{
				cmd = LEFT;
			}
			else if(command.equals(RIGHT.command)) 
			{
				cmd = RIGHT;
			}
			else if(command.equals(REPORT.command)) 
			{
				cmd = REPORT;
			}
		}
		
		return cmd;
	}
}
