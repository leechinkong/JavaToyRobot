package com.lck.toyrobot.model;

public class Table
{
	/** Table x dimension */
	private int dimensionX;
	
	/** Table y dimension */
	private int dimensionY;
	
	/**
	 * Construct table with dimension
	 * @param dimensionX x dimension
	 * @param dimensionY y dimension
	 */
	public Table(int dimensionX, int dimensionY)
	{
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
	}
	
	/**
	 * Validate if x and y is within the table's dimension
	 * @param x the position x
	 * @param y the position y
	 * @return true if x and y is within the table's dimension
	 */
	public boolean validate(int x, int y)
	{
		return x >= 0 && x < dimensionX &&
				y >= 0 && y < dimensionY;
	}
}
