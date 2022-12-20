package org.example;

import java.util.ArrayList;
import java.util.Map;

public class CabBooking {

    private final IInvoice iInvoice;

    //Method for calculating fare
    public double calculateRideFare(double distance, double time) {
        return iInvoice.calculateFare(distance, time);
    }

    //Method for calculating multiple fare and generating invoice details
    public InvoiceDetails calculateRideFare(Ride[] rides) {
        double totalFare = iInvoice.calculateFare(rides);
        return new InvoiceDetails(rides.length, totalFare);
    }

    //Method is invoking multiple rides added for particular user.
    public Map<String, ArrayList<Ride>> addRides(String userId, Ride[] rides) {
        return iInvoice.addRides(userId, rides);
    }

    //Method is invoking getting invoice details of particular user.
    public InvoiceDetails getInvoiceDetails(String userId, Map<String, ArrayList<Ride>> userRides) {
        return iInvoice.getInvoiceDetails(userId, userRides);
    }

    //method for premium rides
    public CabBooking(Invoice.TypeOfSubscription typeOfSubscription) {
        iInvoice = InvoiceFactory.getInvoiceInstance(typeOfSubscription);
    }
}
