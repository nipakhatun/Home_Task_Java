package com.car.parking.model;

public class Car {
    private final double weight;
    private final double height;
    private double unitFactor;
    private ParkingTimer timer;

    public Car(double weight, double height) {
        if(height<=0) {
            throw new RuntimeException("please insert valid height!");
        }
        this.weight = weight;
        this.height = height;
        unitFactor = weight/height;
        timer = new ParkingTimer();
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getUnitFactor() {
        return unitFactor;
    }

    public int getTotalSpendTimeInPark() {
        return timer.currentTimeInMinute();
    }

    public void startPark() {
        timer.setStartTime(System.currentTimeMillis());
    }
}
