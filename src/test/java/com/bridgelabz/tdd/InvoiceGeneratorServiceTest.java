package com.bridgelabz.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvoiceGeneratorServiceTest {

	@Test
	public void givenDistanceAndTime_ReturnTotalFare() {
		
		InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService();
		double distance = 4.5;
		int time = 10;
		double fare = invoiceGeneratorService.CalculateFare(distance, time);
		assertEquals(55, fare, 0.0);
		
	}
	
	@Test
	public void givenLessDistanceAndTime_ReturnMinimumFare() {
		
		InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService();
		double distance = 0;
		int time = 3;
		double fare = invoiceGeneratorService.CalculateFare(distance, time);
		assertEquals(5, fare, 0.0);
		
	}

}
