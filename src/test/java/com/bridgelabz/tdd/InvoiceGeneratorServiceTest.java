package com.bridgelabz.tdd;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorServiceTest {

	InvoiceGeneratorService invoiceGeneratorService;

	@Before
	public void init() {
		invoiceGeneratorService = new InvoiceGeneratorService();
	}

	@Test
	public void givenDistanceAndTime_ReturnTotalFare() throws InvalidUserInputException {

		double distance = 4.5;
		int time = 10;
		double fare = invoiceGeneratorService.CalculateFare(distance, time);
		assertEquals(55, fare, 0.0);

	}

	@Test
	public void givenLessDistanceAndTime_ReturnMinimumFare() throws InvalidUserInputException {

		double distance = 0.1;
		int time = 3;
		double fare = invoiceGeneratorService.CalculateFare(distance, time);
		assertEquals(5, fare, 0.0);

	}

	@Test(expected = InvalidUserInputException.class)
	public void givenZeroDistanceAndTime_ReturnException() throws InvalidUserInputException {

		double distance = 0;
		int time = 3;
		invoiceGeneratorService.CalculateFare(distance, time);

	}

	@Test
	public void givenMultipleRides_ReturnInvoiceSummary() throws InvalidUserInputException {

		Ride[] rides = { new Ride(3.2, 3), new Ride(4.5, 3), new Ride(2.5, 1) };
		InvoiceSummary invoiceSummary = invoiceGeneratorService.CalculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 109, 36.333333333333336);
		assertEquals(expectedInvoiceSummary, invoiceSummary);

	}

	@Test
	public void givenUserId_ReturnInvoiceSummary() throws InvalidUserInputException {

		RideRepository rideRepository = new RideRepository();
		Map<Integer, Ride[]> rideRepo = rideRepository.getRideRepo();
		Ride[] mani = { new Ride(3.2, 3), new Ride(4.5, 3), new Ride(2.5, 1) };
		Ride[] uma = { new Ride(3.2, 3), new Ride(4.5, 3) };

		rideRepo.put(1, mani);
		rideRepo.put(2, uma);

		InvoiceSummary invoiceSummary = invoiceGeneratorService.CalculateFare(2, rideRepo);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 83, 41.5);
		assertEquals(expectedInvoiceSummary, invoiceSummary);

	}

}
