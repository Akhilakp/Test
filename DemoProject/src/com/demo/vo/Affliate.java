/*
 * Copyright 2018
 * Affiliate.java
 * Created on : 18-09-208
 */

package com.demo.vo;

/**
 * Affiliate.java
 * @author Akhila
 *
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
public class Affliate {

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
	public Affliate(){
		this.discountPercentage=10;
	}

}
