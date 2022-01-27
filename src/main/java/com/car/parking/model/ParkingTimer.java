package com.car.parking.model;

public class ParkingTimer {
    private long startTime;

    private long getCurrentTimeDiff() {
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public int currentTimeInMinute() {
       return (int) ((getCurrentTimeDiff()/1000)/60);
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
