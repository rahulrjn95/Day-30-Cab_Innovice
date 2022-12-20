package org.example;

public class CabBooking {
    IInvoice iInvoice = InvoiceFactory.getInvoiceInstance();

    //Method for calculating fare
    public double calculateRideFare(double distance, double time) {
        return iInvoice.calculateFare(distance, time);
    }

    //Method for calculating multiple fare
    public double calculateRideFare(Ride[] rides) {
        return iInvoice.calculateFare(rides);
    }
}
