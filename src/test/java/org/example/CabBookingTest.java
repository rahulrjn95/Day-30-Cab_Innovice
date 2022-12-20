package org.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CabBookingTest {
    private CabBooking cabBooking;

    @Before
    public void setUp() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.NORMAL);
    }


    @Test
    public void givenDistanceTime_WhenCalculateFare_ThenShouldReturnTotalFare() {

        //here as per formula totalFare = ratePerKm * distance + ratePerMinute * time;
        // so (10*15) + (1*20.15) =  180.15
        double totalFare = cabBooking.calculateRideFare(15, 20.55);
        Assert.assertEquals(170.55, totalFare, 1);
    }

    @Test
    public void givenWrongExpectedInput_WhenCalculateFare_ThenShouldReturnTotalFare() {
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertNotEquals(128.15, totalFare, 1);
    }

    //for multiple rides
    @Test
    public void givenMultipleRides_WhenCalculateFare_ThenShouldReturnTotalFare() {
        Ride[] rides = {new Ride(4.8, 10),
                new Ride(10.5, 16),
                new Ride(16, 22)};

        //here for multiple ride [(10*4.8)+(1*10) + (10*10.5)+(1*16) (10*16)+(1*22)]  = 361 i.e total fare.
        InvoiceDetails invoiceDetails = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(361, invoiceDetails.getTotalFare(), 0);
    }

    //generating enhanced invoice to calculate number of rides
    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnNumberOfRides() {
        Ride[] rides = {new Ride(5, 10),
                new Ride(3, 5),
                new Ride(8, 13)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(3, details.getNumOfRides(), 0);
    }

    //generating enhanced invoice to calculate total fare
    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnInvoiceSummaryTotalFare() {
        Ride[] rides = {new Ride(2, 5),
                new Ride(1, 2)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        InvoiceDetails expectedDetails = new InvoiceDetails(2, 37);
        Assert.assertEquals(expectedDetails, details);
    }

    //generating enhanced invoice to calculate average fare per ride
    @Test
    public void givenMultipleRides_WhenCalculateFare_ShouldReturnAverageFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(1, 2.5),
                new Ride(6.2, 15)};
        InvoiceDetails details = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(38.17, details.getAverageFare(), 1);
    }

    //Given userID, the invoice service gets the list of rides from user repository and return invoice.
    @Test
    public void givenUserIdAndRides_WhenCalculateFare_ShouldReturnInvoiceDetails() {
        Map<String, ArrayList<Ride>> userRides;
        String userId = "Rahul01";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(10, 25)};
        userRides = cabBooking.addRides(userId, rides);
        InvoiceDetails details = cabBooking.getInvoiceDetails(userId, userRides);
        InvoiceDetails expectedDetails = new InvoiceDetails(2, 150);
        Assert.assertEquals(expectedDetails, details);
    }

    //for premium ride, calculating total fare
    @Test
    public void givenDistanceTimeForPremiumSubscription_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        //here as per formula totalFare = ratePerKm * distance + ratePerMinute * time;
        // so (15*15) + (2*20.15) =  285.3
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertEquals(285.3, totalFare, 1);
    }


    //for premium ride, calculating total fare for multiple rides
    @Test
    public void givenMultipleRidesForPremiumSubscription_WhenCalculateFare_ThenShouldReturnTotalFare() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        Ride[] rides = {new Ride(4, 10),
                new Ride(10, 15)};
        InvoiceDetails invoiceDetails = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(260, invoiceDetails.getTotalFare(), 0);
    }

    ////for premium ride, given userID invoice service gets the list of rides from user repository and return invoice.
    @Test
    public void givenUserIdAndRidesPremiumSubscription_WhenCalculateFare_ShouldReturnInvoiceDetails() {
        cabBooking = new CabBooking(Invoice.TypeOfSubscription.PREMIUM);
        Map<String, ArrayList<Ride>> userRides;
        String userId = "Vishnu123";
        Ride[] rides = {new Ride(4, 10),
                new Ride(10, 15)};
        userRides = cabBooking.addRides(userId, rides);
        InvoiceDetails details = cabBooking.getInvoiceDetails(userId, userRides);
        InvoiceDetails expectedDetails = new InvoiceDetails(2, 260);
        Assert.assertEquals(expectedDetails, details);
    }
}