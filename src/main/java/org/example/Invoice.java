package org.example;

public class Invoice implements IInvoice{
    //Constants
    double ratePerKm = 10;
    int ratePerMinute = 1;
    double minimumFare = 5;
    double totalFare;

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
}
