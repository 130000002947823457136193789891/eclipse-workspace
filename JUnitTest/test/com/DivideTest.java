package com;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class DivideTest {
	
	private int result=3;
	private Divide d = new Divide();

	@Test
	public void test() {
		
		d.setResult(result);
		d.divide(1);
		assertEquals(3, d.getResult());
	}
	
	@Test(expected=Exception.class)
	public void testZero() throws Exception {
		
		d.setResult(result);
		d.divide(0);
		
	}

}
