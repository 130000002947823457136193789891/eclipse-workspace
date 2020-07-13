package com;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LargestTest {
	
	private Largest largest;
	
	@Before
	public void setUp() throws Exception {
		largest = new Largest();
	}

	@Test(expected=Exception.class)
	public void test1() throws Exception {
		largest.getLargest(null);
	}
	
	@Test(expected=Exception.class)
	public void test2() throws Exception {
		int [] arr = {};
		largest.getLargest(arr);
	}
	
	@Test
	public void test3() throws Exception {
		int [] arr = {1,0,100,-2,-5,99,300};
		int result = largest.getLargest(arr);
		assertEquals(300, result);
	}
	
	@Test
	public void test4() throws Exception {
		int [] arr = {1};
		int result = largest.getLargest(arr);
		assertEquals(1, result);
	}

}
