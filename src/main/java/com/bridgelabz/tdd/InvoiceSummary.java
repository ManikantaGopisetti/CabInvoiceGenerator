package com.bridgelabz.tdd;

public class InvoiceSummary {
	private int numOfRides;
	private double totalFare;
	private double averageFarePerRide;

	public InvoiceSummary(int numOfRides, double totalFare, double averageFarePerRide) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.averageFarePerRide = averageFarePerRide;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		return Double.compare(averageFarePerRide, other.averageFarePerRide) == 0
				&& Integer.compare(numOfRides, other.numOfRides) == 0
				&& Double.compare(totalFare, other.totalFare) == 0;
	}

}
