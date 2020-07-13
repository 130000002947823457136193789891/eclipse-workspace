package com;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TaxTest {
	
	private Tax t = new Tax();
	private double salary;
	private double tax;
	
	@Parameters
	public static Collection prepareData() {
		Object [][] objects = {{0.0,700.0},{0.0,0.0},{20.0,2400.0},
				{25.0,2500.0},{60.0,2600.0},
				{200.0,4000.0},{330.0,4200.0},{750.0,7000.0},
				{1040.0,7200.0}
				,{4000.0,22000.0},{5250.0,23000.0},{10000.0,42000.0},
				{12300.0,43000.0},{18000.0,62000.0},{21350.0,63000.0},
				{28000.0,82000.0},
				{32400.0,83000.0},{40000.0,102000.0},{45450.0,103000.0}};
		return Arrays.asList(objects);
		
	}
	
	public TaxTest(double tax, double salary) {
		this.salary = salary;
		this.tax = tax;
	}
	
	
	@Test
	public void testTax() {
		double result;
		t.setSalary(salary);
		t.caculate();
		result = t.getTax();
		assertEquals((long)tax,(long) result);
	}

}
