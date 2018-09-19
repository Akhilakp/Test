package com.demo.controller;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.demo.vo.Payment;

 class PaymentControllerTest {

	private static PaymentController paymentController;
	private static Method method;
	private static Payment paymentVO;

	@BeforeAll
	public static void beforeClass() {
		paymentController =new PaymentController();
		
	}

	@BeforeEach
	void init() throws NoSuchMethodException, SecurityException {
		paymentVO= new Payment();
		method = PaymentController.class.getDeclaredMethod("calculatePayableAmount", Payment.class);
		method.setAccessible(true);
	}
	
	@DisplayName("Empoyee without groceries")
	@Test
	void employeeWithoutGroceriesTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(1);
		paymentVO.setAmount(500);
		paymentVO.setGroceries(false);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}

	@DisplayName("Empoyee with groceries")
	@Test
	void employeeWithGroceriesTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(1);
		paymentVO.setAmount(500);
		paymentVO.setGroceries(true);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());

	}
	
	@DisplayName("Affliate without groceries")
	@Test
	void affiliateWithoutGroceriesTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(2);
		paymentVO.setAmount(575.5);
		paymentVO.setGroceries(false);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}

	@DisplayName("Affiliate with groceries")
	@Test
	void affiliateWithGroceriesTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(2);
		paymentVO.setAmount(1000);
		paymentVO.setGroceries(true);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}
	@DisplayName("Customer without groceries and amount reater than 100")
	@Test
	void customerWithoutGroceriesTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(3);
		paymentVO.setAmount(600);
		paymentVO.setGroceries(false);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}

	@DisplayName("Customer with groceries")
	@Test
	void customerWithGroceriesTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(3);
		paymentVO.setAmount(1000);
		paymentVO.setGroceries(true);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}
	
	@DisplayName("Customer without groceries and year of purchase less than 2")
	@Test
	void customerYearOfPurchaseLessTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(3);
		paymentVO.setAmount(1000);
		paymentVO.setGroceries(false);
		paymentVO.setYearofPurchase(1);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}

	@DisplayName("Customer without groceries and year of purchase greater than 2")
	@Test
	void customerYearOfPurchaseGreaterTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(3);
		paymentVO.setAmount(1000);
		paymentVO.setGroceries(false);
		paymentVO.setYearofPurchase(2.5);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}
	
	
	@DisplayName("Customer year ofpurchase less than 2 and amount less than 100")
	@Test
	void customerYearAndAmountLessTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(3);
		paymentVO.setAmount(75);
		paymentVO.setGroceries(false);
		paymentVO.setYearofPurchase(1);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}

	@DisplayName("Customer year ofpurchase less than 2 and amount greater than 100")
	@Test
	void customerYearAndAmountGreaterTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		paymentVO.setUserType(3);
		paymentVO.setAmount(500);
		paymentVO.setGroceries(false);
		paymentVO.setYearofPurchase(1);
		paymentVO=(Payment) method.invoke(paymentController, paymentVO);
		System.out.println("Total Bill Amount :"+paymentVO.getAmount());
		System.out.println("Disount Amount :"+paymentVO.getDiscountCredited());
		System.out.println("The Net Payable Amount :"+paymentVO.getPayableAmount());


	}

	
}
