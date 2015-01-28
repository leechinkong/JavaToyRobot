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
	
	public Face turn(Command turnCmd) 
	{
		Face[] faces = Face.values();
		Face newFace;
		switch (turnCmd)
		{
			case LEFT:
				int leftIndex = ordinal() - 1;
				newFace = faces[leftIndex < 0 ? faces.length - 1 : leftIndex];
				break;
			case RIGHT:
				int rightIndex = ordinal() + 1;
				newFace = faces[rightIndex >= faces.length ? 0 : rightIndex];
				break;
			default:
				newFace = this;
				break;
		}
		
		return newFace;
	}
	
	@Override
	public String toString()
	{
		return face;
	}
}
