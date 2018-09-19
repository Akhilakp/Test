/*
 * Copyright 2018
 * Payment.java
 * Created on : 18-09-208
 */

package com.demo.vo;

/**
 * PaymentController
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
public class Payment {
	
	/**
	 * userType
	 */
	private Integer userType;
	/**
	 * amount -Total amount purchased
	 */
	private double amount;
	
	/**
	 * yearofPurchase -how long the customer is purchasing
	 * 
	 */
	private double   yearofPurchase;
	 
	/**
	 * isGroceries
	 */
	private boolean isGroceries;
	
	/**
	 * payableAmount -Amount after discount
	 */
	private double payableAmount;
	
	/**
	 * discountCredited -calculated discount amount
	 */
	private double discountCredited;
	

	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getYearofPurchase() {
		return yearofPurchase;
	}

	public void setYearofPurchase(double yearofPurchase) {
		this.yearofPurchase = yearofPurchase;
	}

	public boolean isGroceries() {
		return isGroceries;
	}

	public void setGroceries(boolean isGroceries) {
		this.isGroceries = isGroceries;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	public double getDiscountCredited() {
		return discountCredited;
	}

	public void setDiscountCredited(double discountCredited) {
		this.discountCredited = discountCredited;
	}

}
