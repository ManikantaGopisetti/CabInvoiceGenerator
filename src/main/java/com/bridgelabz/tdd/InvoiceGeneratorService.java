package com.bridgelabz.tdd;

public class InvoiceGeneratorService {

	private static final int COST_PER_MINUTE = 1;
	private static final double COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;

	public double CalculateFare(double distance, int time) {

		double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare > MINIMUM_FARE) {
			return totalFare;
		}
		return MINIMUM_FARE;

	}

}
