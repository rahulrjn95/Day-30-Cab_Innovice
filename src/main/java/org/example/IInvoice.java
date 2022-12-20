package org.example;

public interface IInvoice {
    //for single ride
    double calculateFare(double distance, double time);

    //for multiple rides
    double calculateFare(Ride[] rides);

}
