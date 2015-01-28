package com.lck.toyrobot;

import com.lck.toyrobot.model.Robot;
import com.lck.toyrobot.model.Table;

/**
 * 
 * Toy robot controller containing logic to control robot movement
 * 
 * @author lee
 *
 */
public class ToyRobotController
{
	/** Default table x dimension */
	public static final int DIMENSION_X = 5;
	
	/** Default table y dimension */
	public static final int DIMENSION_Y = 5;
	
	/** Table instance */
	private Table table;
	
	/** Robot instance */
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
			else
			{
				// update robot
				robot.setX(x);
				robot.setY(y);
				robot.setFace(face);
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
			// calculate the new x,y
			int x = robot.getX();
			int y = robot.getY();
			switch (robot.getFace())
			{
				case NORTH:
					y++;
					break;
				case EAST:
					x++;
					break;
				case SOUTH:
					y--;
					break;
				case WEST:
					x--;
					break;
			}
			
			// validate x,y
			if(table.validate(x, y))
			{
				// update robot's position
				robot.setX(x);
				robot.setY(y);
			}
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
			final Face currentFace = robot.getFace();
			robot.setFace(currentFace.turn(turnCmd));
		}
	}
	
	/**
	 * Report position and face
	 * @return the report output
	 */
	public String report()
	{	
		String output = null;
		
		// robot is null when not yet placed
		if(robot != null)
		{
			output = String.format("Output: %d,%d,%s", robot.getX(), robot.getY(), robot.getFace());
		}
		
		return output;
	}
}
