package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CabBookingTest {
    @Before
    public void setUp() {
        cabBooking = new CabBooking();
    }

    private CabBooking cabBooking;

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

    @Test
    public void givenMultipleRides_WhenCalculateFare_ThenShouldReturnTotalFare() {
        Ride[] rides = {new Ride(4.8, 10),
                new Ride(10.5, 16),
                new Ride(16, 22)};

        //here for multiple ride [(10*4.8)+(1*10) + (10*10.5)+(1*16) (10*16)+(1*22)]  = 361 i.e total fare.
        double totalFare = cabBooking.calculateRideFare(rides);
        Assert.assertEquals(361, totalFare, 0);
    }
}