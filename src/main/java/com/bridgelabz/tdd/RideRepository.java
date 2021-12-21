package com.bridgelabz.tdd;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {

	public Map<Integer, Ride[]> rideRepo = new HashMap<Integer, Ride[]>();

	public Map<Integer, Ride[]> getRideRepo() {
		return rideRepo;
	}

}
