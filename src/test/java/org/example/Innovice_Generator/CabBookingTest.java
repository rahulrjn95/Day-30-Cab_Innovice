package org.example.Innovice_Generator;

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
        // so (10*15) + (1*30.15) =  180.15
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertEquals(180.15, totalFare, 1);
    }

    @Test
    public void givenWrongExpectedInput_WhenCalculateFare_ThenShouldReturnTotalFare() {
        double totalFare = cabBooking.calculateRideFare(15, 30.15);
        Assert.assertNotEquals(128.15, totalFare, 1);
    }
}