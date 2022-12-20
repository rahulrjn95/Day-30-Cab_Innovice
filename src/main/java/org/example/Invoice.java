package org.example;

import java.util.ArrayList;
import java.util.Map;

public class Invoice implements IInvoice{
    //Constants
    double ratePerKm;
    int ratePerMinute;
    double minimumFare;
    double totalFare;
    private RideRepository rideRepository;

    public enum TypeOfSubscription {NORMAL, PREMIUM}

    public Invoice(TypeOfSubscription typeOfSubscription) {
        if (typeOfSubscription.equals(TypeOfSubscription.PREMIUM)) {
            this.ratePerKm = 15;
            this.ratePerMinute = 2;
            this.minimumFare = 20;
        } else if (typeOfSubscription.equals(TypeOfSubscription.NORMAL)) {
            this.ratePerKm = 10;
            this.ratePerMinute = 1;
            this.minimumFare = 5;
        }
    }

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
