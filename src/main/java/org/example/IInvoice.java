package org.example;

import java.util.ArrayList;
import java.util.Map;

public interface IInvoice {
    //for single ride
    double calculateFare(double distance, double time);

    //for multiple rides
    double calculateFare(Ride[] rides);

    Map<String, ArrayList<Ride>> addRides(String userId, Ride[] rides);

    InvoiceDetails getInvoiceDetails(String userId, Map<String, ArrayList<Ride>> userRides);


}
