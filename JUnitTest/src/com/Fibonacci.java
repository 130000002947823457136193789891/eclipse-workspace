package com;

public class Fibonacci {
	public static int compute(int num) throws Exception{  	 	if(num < 0){ 
	 	 	throw new Exception("��������С�� 0��"); 
	 	} 
	 	if (num ==0){ 
	 	 	return 0; 
	 	} 
	 	else if(num ==1 || num==2){  	 	 	
	 		return 1; 
	 	} 
	 	else{ 
	 	 	return (compute(num-1)+compute(num-2)); 
	 	} 
	} 

}
