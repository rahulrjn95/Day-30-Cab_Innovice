package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class RideRepository {
    //Method for adding ride logic
    public Map<String, ArrayList<Ride>> addRides(String userId, Ride[] rides) {
        Map<String, ArrayList<Ride>> userRides = new HashMap<>();
        userRides.computeIfAbsent(userId, k -> new ArrayList<>(Arrays.asList(rides)));
        return userRides;
    }

    //Method for getting ride detail of particular user
    public Ride[] getRidesByUserId(String userId, Map<String, ArrayList<Ride>> userRides) {
        return userRides.get(userId).toArray(new Ride[0]);
    }
}
