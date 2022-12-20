package org.example;

public class CabBooking {
    IInvoice iInvoice = InvoiceFactory.getInvoiceInstance();

    //Method for calculating fare
    public double calculateRideFare(double distance, double time) {
        return iInvoice.calculateFare(distance, time);
    }

    //Method for calculating multiple fare and generating invoice details
    public InvoiceDetails calculateRideFare(Ride[] rides) {
        iInvoice = InvoiceFactory.getInvoiceInstance();
        double totalFare=iInvoice.calculateFare(rides);
        return new InvoiceDetails(rides.length,totalFare);
    }
}
