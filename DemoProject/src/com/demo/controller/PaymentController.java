/*
 * Copyright 2018
 * PaymentController.java
 * Created on : 18-09-208
 *
 */

package com.demo.controller;

import java.util.Scanner;

import com.demo.vo.Affliate;
import com.demo.vo.Customer;
import com.demo.vo.Employee;
import com.demo.vo.Payment;


/**
 * PaymentController.java
 * The PaymentController handle the discount for the different user
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
public class PaymentController {


	/**
	 * EMPLOYEE
	 */

	public static final Integer EMPLOYEE=1;

	/**
	 * AFFILIATE
	 */
	public static final Integer AFFILIATE=2;

	/**
	 * CUSTOMER
	 */
	public static final Integer CUSTOMER=3;

	/**
	 * MINIMUM_DISCOUNT_UNIT
	 */
	public static final Integer MINIMUM_DISCOUNT_UNIT=100;

	/**
	 * This is the main method which makes use of calculatePayableAmount method.
	 * @param args Unused.
	 * @return Nothing.
	 */
	public static void main(String Args[]) {

		Scanner input=new Scanner(System.in);
		System.out.println("Enter the type of user");
		System.out.println("1.Employee");
		System.out.println("2.Affiliate");
		System.out.println("3.Customer");

		while (!input.hasNext("[123]")) {
		    System.out.println("Please Enter the correct value!");
		    input.next();
		}
		Integer userType=input.nextInt();
		double yearOfPurchase=0;

		if(userType !=null && CUSTOMER == userType) {
			System.out.println("Enter the total year of purchase");
			while (!input.hasNextDouble()) {
			    System.out.println("Please Enter the correct value!");
			    input.next();
			}
			yearOfPurchase=input.nextDouble();
		}
		System.out.print("Enter bill amount:");

		
		while (!input.hasNextDouble()) {
		    System.out.println("Please Enter the correct value!");
		    input.next();
		}
		
		double amount=input.nextDouble();
		if(amount!=0) {

			System.out.println("Enter the type of purchase");
			System.out.println("1.Groceries");
			System.out.println("2.Other");
			
			while (!input.hasNext("[12]")) {
			    System.out.println("Please Enter the correct value!");
			    input.next();
			}
			Integer typeOfPurchase=input.nextInt();
			Payment paymentVO= new Payment();
			paymentVO.setUserType(userType);;
			paymentVO.setAmount(amount);
			paymentVO.setYearofPurchase(yearOfPurchase);
			if(typeOfPurchase !=0 && 1 ==typeOfPurchase) {
				paymentVO.setGroceries(true);
			}
			paymentVO= calculatePayableAmount(paymentVO);
			if(paymentVO.getPayableAmount() !=0) {
				System.out.println("Total Bill Amount :"+paymentVO.getAmount());
				System.out.println("Discount Amount :"+paymentVO.getDiscountCredited());
				System.out.println("Net Payable Amount :"+paymentVO.getPayableAmount());

			}

		}else {
			System.out.println("Please enter valid amount");
		}

	}


	/**
	 * calculatePayableAmount
	 * This method used to find the payable amount after discount
	 * @param paymentVO
	 * @return paymentVO
	 * 
	 */
	private static Payment calculatePayableAmount(Payment paymentVO) {

		if(paymentVO != null && !paymentVO.isGroceries()){
			
			if(EMPLOYEE.equals(paymentVO.getUserType())) {
				Employee employee= new Employee();
				if(paymentVO.getAmount() !=0 && employee.getDiscountPercentage()!=0) {
					double discountAmount=paymentVO.getAmount()*employee.getDiscountPercentage()/100;
					double payableAmount=paymentVO.getAmount()-discountAmount;
					paymentVO.setDiscountCredited(discountAmount);
					paymentVO.setPayableAmount(payableAmount);
				}

			}else if(AFFILIATE.equals(paymentVO.getUserType())) {
				Affliate affliate= new Affliate();
				if(paymentVO.getAmount() !=0 && affliate.getDiscountPercentage()!=0) {
					double discountAmount=paymentVO.getAmount()*affliate.getDiscountPercentage()/100;
					double payableAmount=paymentVO.getAmount()-discountAmount;
					paymentVO.setDiscountCredited(discountAmount);
					paymentVO.setPayableAmount(payableAmount);
				}

			}else if(CUSTOMER.equals(paymentVO.getUserType())) {
				Customer customer= new Customer();
				if(2 <=paymentVO.getYearofPurchase()) {
					if(paymentVO.getAmount() !=0 && customer.getDiscountPercentage()!=0) {
						double discountAmount=paymentVO.getAmount()*customer.getDiscountPercentage()/100;
						double payableAmount=paymentVO.getAmount()-discountAmount;
						paymentVO.setDiscountCredited(discountAmount);
						paymentVO.setPayableAmount(payableAmount);
					}
				}else if(paymentVO.getAmount() >=MINIMUM_DISCOUNT_UNIT) {
					Integer hundreds = (int) (paymentVO.getAmount() / MINIMUM_DISCOUNT_UNIT);
					double discountAmount=hundreds*customer.getDiscountUnitAmount();
					double payableAmount=paymentVO.getAmount()-discountAmount;
					paymentVO.setDiscountCredited(discountAmount);
					paymentVO.setPayableAmount(payableAmount);

				}else {
					paymentVO.setDiscountCredited(0);
					paymentVO.setPayableAmount(paymentVO.getAmount());
				}
			}

		}else {
			paymentVO.setDiscountCredited(0);
			paymentVO.setPayableAmount(paymentVO.getAmount());
		}
		return paymentVO;
	}

}
