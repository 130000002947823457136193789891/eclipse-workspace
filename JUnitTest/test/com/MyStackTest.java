package com;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {
	
	private MyStack stack = new MyStack();
	private String [] elements;
	private int nextIndex;

	@Test(expected=Exception.class)
	public void testPush0() throws Exception {
		
		int i;
		for (i=0;i<100;i++) {
			stack.push(i+"");
		}
		stack.push("");
	}
	
	@Test
	public void testPush1() throws Exception {
		
		int i;
		for (i=0;i<10;i++) {
			stack.push(i+"");
		}
		
		for (i=0;i<9;i++) {
			stack.pop();
		}
		
		assertEquals("0", stack.pop());
	}
	
	@Test(expected=Exception.class)
	public void testPop0() throws Exception {
		
		stack.pop();
	}
	
	@Test
	public void testPop1() throws Exception {
		
		int i;
		for (i=0;i<10;i++) {
			stack.push(i+"");
		}
		
		assertEquals("9", stack.pop());
	}
	
	@Test(expected=Exception.class)
	public void testTop() throws Exception {
		
		stack.top();
	}
	
	@Test
	public void testTop1() throws Exception {
		
		int i;
		for (i=0;i<10;i++) {
			stack.push(i+"");
		}
		
		assertEquals("9", stack.top());
	}
	
	@Test(expected=Exception.class)
	public void testDelete0() throws Exception {
		
		int i;
		for (i=0;i<100;i++) {
			stack.push(i+"");
		}
		stack.delete(101);
	}
	
	@Test
	public void testDelete1() throws Exception {
		
		int i;
		for (i=0;i<10;i++) {
			stack.push(i+"");
		}
		
		stack.delete(9);
		
		assertEquals("0", stack.top());
	}

}
