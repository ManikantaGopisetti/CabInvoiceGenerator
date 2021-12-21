package com.bridgelabz.tdd;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class InvoiceGeneratorService {
	enum Ridetype {
		PREMIUM, NORMAL
	}

	private static final int COST_PER_MINUTE = 1;
	private static final double COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;
	private static final int PREMIUM_COST_PER_MINUTE = 2;
	private static final double PREMIUM_COST_PER_KM = 15;
	private static final double PREMIUM_MINIMUM_FARE = 20;

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

	public InvoiceSummary CalculateFare(Ride[] rides, Ridetype ridetype) throws InvalidUserInputException {

		if (ridetype == Ridetype.PREMIUM) {
			double aggregateFare = 0;
			for (Ride ride : rides) {

				if (ride.distance <= 0) {
					throw new InvalidUserInputException("Distance can't be less than or equal to zero");
				}
				double totalFare = ride.distance * PREMIUM_COST_PER_KM + ride.time * PREMIUM_COST_PER_MINUTE;
				if (totalFare > PREMIUM_MINIMUM_FARE) {
					aggregateFare += totalFare;
				} else {
					aggregateFare += PREMIUM_MINIMUM_FARE;
				}
			}
			return new InvoiceSummary(rides.length, aggregateFare, aggregateFare / rides.length);
		} else if (ridetype == Ridetype.NORMAL) {
			return CalculateFare(rides);
		}
		return null;

	}

}
