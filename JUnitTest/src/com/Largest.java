package com;

public class Largest{ 
 	public int getLargest(int[] array) throws Exception{  	 	
 		if (array==null || array.length==0){ 
 	 	 	throw new Exception("数组不能为空"); 
 	 	} 
 	 	int result=array[0]; 
 	 	for(int i=0;i<array.length;i++){  	 	 	
 	 		if(result<array[i]) 
 	 	 	 	result=array[i]; 
 	 	} 
 	 	return result; 
 	} 
} 

