package org.example;

import java.util.Objects;

public class InvoiceDetails {
    private final double averageFare;
    private final double totalFare;
    private final int numOfRides;

    public InvoiceDetails(int length, double totalFare) {
        this.numOfRides = length;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numOfRides;
    }

    public double getAverageFare() {
        return averageFare;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public int getNumOfRides() {
        return numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetails that = (InvoiceDetails) o;
        return Double.compare(that.averageFare, averageFare) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                numOfRides == that.numOfRides;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageFare, totalFare, numOfRides);
    }
}
