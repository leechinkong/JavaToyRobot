package com.lck.toyrobot;

public enum Face
{
	NORTH("NORTH"),
	EAST("EAST"),
	SOUTH("SOUTH"),
	WEST("WEST");
	
	private String face;
	private Face(String face) 
	{
		this.face = face;
	}
	
	@Override
	public String toString()
	{
		return face;
	}
}
