
/*
 * Copyright 2018
 * Employee.java
 * Created on : 18-09-208
 */
package com.demo.vo;

/**
 * Employee.java
 * @author Akhila
 *-----------------------------------------------------------------------------
 * Revision History (Release 1.0.0.0)
 *-----------------------------------------------------------------------------
 * VERSION     AUTHOR/      DESCRIPTION 
 *             DATE            
 *-----------------------------------------------------------------------------
 * 1.0     | Akhila        | Initial Create.
 *         | 18-09-2018    |
 *---------|---------------|---------------------------------------------------
 */
public class Employee {
	
	/**
	 * discountPercentage
	 */
	private double discountPercentage;

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	/**
	 * Constructor
	 */
	public Employee(){
		discountPercentage=30;
	}
	
}
