/********************************************************************************* *
 * Purpose: To Test the Addition class via Junit
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz.Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Saurav:
 * Class to perform sample testing of add method
 */
public class AdditionTest {
	/**
	 * Method to use @beforeClass annotation
	 */
	@BeforeClass
	public static void SetUpBeforeClass()//should be static
	{
		System.out.println("BeforeClass");
	}
	/**
	 * Method to use @Before annotation
	 */
	@Before
	public void Before()
	{
		System.out.println("Before");
	}
	/**
	 * Method to use @After annotation
	 */
	@After
	public void SetUpAfter()
	{
		System.out.println("After");
	}
	/**
	 * Method to use @AfterClass annotation
	 */
	@AfterClass
	public static void SetUpAfterClass() //method setupAfterClass should be static
	{
		System.out.println("AfterClass");
	}
	/**
	 * Method to use @Test annotation.This is the main Test unit.
	 */
	@Test
	public void testAdd() {
		assertEquals(6, Addition.add(2, 4));
		System.out.println("Hello");
	}
}
