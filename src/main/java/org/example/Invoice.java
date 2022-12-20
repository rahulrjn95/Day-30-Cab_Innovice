package org.example;

import java.util.ArrayList;
import java.util.Map;

public class Invoice implements IInvoice{
    //Constants
    double ratePerKm = 10;
    int ratePerMinute = 1;
    double minimumFare = 5;
    double totalFare;
    private RideRepository rideRepository;

    //Calculating Fare
    @Override
    public double calculateFare(double distance, double time) {

        double totalFare = ratePerKm * distance + ratePerMinute * time;
        return Math.max(totalFare, minimumFare);
    }

    //calculating total fares for multiple rides
    @Override
    public double calculateFare(Ride[] rides) {
        for (Ride ride : rides)
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        return Math.max(totalFare, minimumFare);
    }

    //Method for inserting multiple rides
    @Override
    public Map<String, ArrayList<Ride>> addRides(String userId, Ride[] rides) {
        rideRepository = new RideRepository();
        return rideRepository.addRides(userId, rides);
    }

    //Method for getting rides detail of particular user
    @Override
    public InvoiceDetails getInvoiceDetails(String userId, Map<String, ArrayList<Ride>> userRides) {
        rideRepository = new RideRepository();
        totalFare = calculateFare(rideRepository.getRidesByUserId(userId, userRides));
        return new InvoiceDetails(rideRepository.getRidesByUserId(userId, userRides).length, totalFare);
    }
}
