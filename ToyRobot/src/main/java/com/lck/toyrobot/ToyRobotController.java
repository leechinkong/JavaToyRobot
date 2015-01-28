package com.lck.toyrobot;

import com.lck.toyrobot.model.Robot;
import com.lck.toyrobot.model.Table;

public class ToyRobotController
{
	/** Default table x dimension */
	public static final int DIMENSION_X = 5;
	
	/** Default table y dimension */
	public static final int DIMENSION_Y = 5;
	
	private Table table;
	private Robot robot;
	/**
	 * Construct toy robot controller
	 */
	public ToyRobotController()
	{
		this.table = new Table(DIMENSION_X, DIMENSION_Y);
	}
	
	/**
	 * Place robot at position
	 * @param x position x
	 * @param y position y
	 * @param face direction facing
	 */
	public void place(int x, int y, Face face)
	{
		if(table.validate(x, y))
		{
			if(robot == null)
			{
				// construct the robot
				robot = new Robot(x, y, face);
			}
		}
	}
	
	/**
	 * Move forward in direction currently face
	 */
	public void move()
	{
		// robot is null when not yet placed
		if(robot != null)
		{
			
		}
	}
	
	/**
	 * Turn left or right
	 * @param turnCmd left or right command.
	 */
	public void turn(Command turnCmd)
	{
		// robot is null when not yet placed
		if(robot != null)
		{
			
		}
	}
	
	/**
	 * Report position and face
	 */
	public String report()
	{	
		String output = null;
		
		// robot is null when not yet placed
		if(robot != null)
		{
			
		}
		
		return output;
	}
}
