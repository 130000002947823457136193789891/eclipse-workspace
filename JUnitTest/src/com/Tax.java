package com;

public class Tax {

	private double salary;
	private double rate;
	private double tax;
	
	public Tax() {
		
		salary = 0;
		rate = 0;
		tax = 0;
	}
	
	public void caculate() {
		
		if(salary<2000)
			tax=0;
		
		salary = salary -2000;
		tax = salary * rate;
		
	}
	
	public double getTax() {
		
		return tax;
	}
	
	public void setSalary(double s) {
		
		salary = s;
		
		if(s<0)
			System.out.println("工资为正数。");
		
		if(s>=0 && s<=2000)
			rate = 0;
		
		if(s>2000 && s<=2500)
			rate = 0.05;
		
		if(s>2500 && s<=4000)
			rate = 0.10;
		
		if(s>4000 && s<=7000)
			rate = 0.15;
		
		if(s>7000 && s<=22000)
			rate = 0.20;
		
		if(s>22000 && s<=42000)
			rate = 0.25;
		
		if(s>42000 && s<=62000)
			rate = 0.30;
		
		if(s>62000 && s<=82000)
			rate = 0.35;
		
		if(s>82000 && s<=102000)
			rate = 0.40;
		
		if(s>102000)
			rate = 0.45;
	}
	
	public double getSalary() {
		
		return salary;
	}
	
	public double getRate() {
		
		return rate;
	}
	
}
