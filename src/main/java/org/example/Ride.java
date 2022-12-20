package org.example;

public class Ride {
    private final double time;
    private final double distance;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }
}
