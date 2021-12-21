package com.bridgelabz.tdd;

public class InvoiceGeneratorService {

	private static final int COST_PER_MINUTE = 1;
	private static final double COST_PER_KM = 10;

	public double CalculateFare(double distance, int time) {

		return distance * COST_PER_KM + time * COST_PER_MINUTE;
	}

}
