package com.car.parking;

import com.car.parking.dao.ParkingFloorRepository;
import com.car.parking.model.Car;
import com.car.parking.model.Floor;
import com.car.parking.worker.ParkingScanner;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ProcessWorkerTest {
    ParkingScanner parkingScanner;
    Car car1;
    @Before
    public void setUp() {
        parkingScanner = new ParkingScanner();
        car1 = new Car(20, 5.5);
    }

    public void doStart(){
        parkingScanner.scanParkingFloor(car1);
        Floor selectedFloor = ParkingFloorRepository.getInstance().getSelectedFloor();
        Assert.assertEquals(selectedFloor.getFloorNumber(), 3);
    }

}
