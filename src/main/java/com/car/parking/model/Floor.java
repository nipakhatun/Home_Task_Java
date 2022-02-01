package com.car.parking.model;

public class Floor {
    private int floorNumber;
    private final double height;
    private final double totalWeight;
    private volatile double occupiedWeight;
    private double unitPrice;

    public Floor(int floorNumber,double height, double totalWeight) {
        if (height <= 0) {
            throw new RuntimeException("please insert valid height!");
        }
        this.floorNumber = floorNumber;
        this.height = height;
        this.totalWeight = totalWeight;
        unitPrice = totalWeight / height;
    }

    public double getHeight() {
        return height;
    }

    public double getAvailableWeight() {
        double diff = totalWeight - occupiedWeight;
        if (diff < 0) {
            diff = 0;
        }
        return diff;
    }

    private synchronized void calculateWeight(double weight) {
        occupiedWeight = occupiedWeight + weight;
    }
    public void setOccupiedFloor(Car car) {
        calculateWeight(car.getWeight());
    }

    public void doReleaseFloor(Car car) {
        calculateWeight(car.getWeight() * -1);
    }

    public double getCurrentUnitFactor() {
        double availableWeight = totalWeight - occupiedWeight;
        if (availableWeight <= 0) {
            return 0;
        }
        return availableWeight / height;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalFare(Car car) {
        return unitPrice*car.getTotalSpendTimeInPark();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
