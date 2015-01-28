package com.lck.toyrobot.model;

import com.lck.toyrobot.Face;

public class Robot
{
	private int x;
	private int y;
	private Face face;
	
	public Robot(int x, int y, Face face)
	{
		this.x = x;
		this.y = y;
		this.face = face;
	}
	
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public Face getFace()
	{
		return face;
	}
	public void setFace(Face face)
	{
		this.face = face;
	}
	
	
}
