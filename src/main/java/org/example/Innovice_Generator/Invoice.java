package org.example.Innovice_Generator;

public class Invoice implements IInvoice{
    //Calculating Fare
    @Override
    public double calculateFare(double distance, double time) {
        //Constants
        double ratePerKm = 10;
        int ratePerMinute = 1;
        double totalFare = ratePerKm * distance + ratePerMinute * time;
        double minimumFare = 5;
        return Math.max(totalFare, minimumFare);
    }
}
