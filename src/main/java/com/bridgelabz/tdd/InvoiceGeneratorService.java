package com.bridgelabz.tdd;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class InvoiceGeneratorService {

	private static final int COST_PER_MINUTE = 1;
	private static final double COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;

	public double CalculateFare(double distance, int time) throws InvalidUserInputException {
		if (distance <= 0) {
			throw new InvalidUserInputException("Distance can't be less than or equal to zero");
		}
		double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare > MINIMUM_FARE) {
			return totalFare;
		}
		return MINIMUM_FARE;

	}

	public InvoiceSummary CalculateFare(Ride[] rides) throws InvalidUserInputException {
		double aggregateFare = 0;
		for (Ride ride : rides) {
			aggregateFare += CalculateFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rides.length, aggregateFare, aggregateFare / rides.length);
	}

	public InvoiceSummary CalculateFare(int userId, Map<Integer, Ride[]> rideRepo) throws InvalidUserInputException {

		Iterator<Entry<Integer, Ride[]>> iterator = rideRepo.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Ride[]> entry = iterator.next();
			if (entry.getKey().equals(userId)) {
				return CalculateFare(entry.getValue());
			}
		}
		return null;
	}

}
