package com;

public class MyStack {
	
	private String[] elements;  	
	int nextIndex;  
	
	public MyStack() 
 	{ 
 	 	elements = new String[100];  	 	nextIndex=0; 
 	} 
 	 
 	public void push(String element)throws Exception 
 	{ 
 	 	if(nextIndex==100) 	 
 	 	{ 
 	 	 	throw new Exception("����Խ�磡"); 
 	 	} 
 	 	elements[nextIndex++]=element; 
 	} 
 	 
 	public String pop()throws Exception 
 	{ 	 
 	 	if(nextIndex==0) 
 	 	{ 
 	 	 	throw new Exception("����Խ�磡"); 
 	 	} 
 	 	 
 	 	return elements[--nextIndex]; 
 	} 
 	 
 	public String top()throws Exception 
 	{ 
 	 	if(nextIndex==0) 
 	 	{ 
 	 	 	throw new Exception("����Խ�磡"); 
 	 	} 
 	 	 
 	 	return elements[nextIndex-1]; 
 	} 
 
 	public void delete(int n)throws Exception 
 	{ 
 	 	if(nextIndex-n<0) 
 	 	{ 
 	 	 	throw new Exception("����Խ�磡"); 
 	 	} 
 	 	nextIndex -= n; 
 	 	 
 	} 

}
