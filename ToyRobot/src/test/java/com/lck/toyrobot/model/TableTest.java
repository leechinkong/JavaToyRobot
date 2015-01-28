package com.lck.toyrobot.model;

import junit.framework.TestCase;

/**
 * Test for Table class
 * 
 * @author lee
 *
 */
public class TableTest extends TestCase
{
	/**
	 * Test validate method
	 */
	public void testValidate()
	{
		final Table table = new Table(5, 5);
		assertTrue(table.validate(2, 2));
		assertTrue(table.validate(1, 4));
		assertTrue(table.validate(0, 3));
		assertTrue(table.validate(3, 2));
		assertFalse(table.validate(5, 5));
		assertFalse(table.validate(-1, 4));
		assertFalse(table.validate(0, 5));
		assertFalse(table.validate(5, 2));
	}
}
