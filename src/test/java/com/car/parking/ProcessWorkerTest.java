package com.car.parking;

import com.car.parking.model.Car;
import com.car.parking.worker.ParkingScanner;
import org.junit.Before;
import org.junit.Test;

@Test
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
    }

}
