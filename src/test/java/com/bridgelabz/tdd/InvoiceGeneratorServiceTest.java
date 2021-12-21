package com.bridgelabz.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorServiceTest {
	
	InvoiceGeneratorService invoiceGeneratorService;
	
	@Before
	public void init() {
		invoiceGeneratorService =new InvoiceGeneratorService();
	}
	

	@Test
	public void givenDistanceAndTime_ReturnTotalFare() throws InvalidUserInputException {
		 
		double distance = 4.5;
		int time = 10;
		double fare = invoiceGeneratorService.CalculateFare(distance, time);
		assertEquals(55, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_ReturnMinimumFare() throws InvalidUserInputException{
		
		double distance = 0.1;
		int time = 3;
		double fare = invoiceGeneratorService.CalculateFare(distance, time);
		assertEquals(5, fare, 0.0);
		
	}
	
	@Test(expected =InvalidUserInputException.class)
	public void givenZeroDistanceAndTime_ReturnException() throws InvalidUserInputException {
		
		double distance = 0;
		int time = 3;
		invoiceGeneratorService.CalculateFare(distance, time);
		
	}

}
