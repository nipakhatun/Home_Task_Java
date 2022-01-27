package com.car.parking.worker;


import com.car.parking.dao.ParkingFloorRepository;
import com.car.parking.model.Car;
import com.car.parking.model.Floor;

public class ProcessWorker {
    private final ParkingScanner scanner;

    public ProcessWorker() {
        scanner = new ParkingScanner();
    }

    public void doStart() throws InterruptedException {
        Car car1 = new Car(20, 5.5);
        Car car2 = new Car(25, 6.7);

        startProcess(car1);
        Thread.sleep(100000);
        endProcess(ParkingFloorRepository.getInstance().getSelectedFloor(), car1);
    }

    public synchronized void startProcess(Car inputCar) {
        scanner.scanParkingFloor(inputCar);
        Floor selectedFloor = ParkingFloorRepository.getInstance().getSelectedFloor();
        if (selectedFloor==null) {
            System.out.println("No floor found to park the car!");
            return;
        }
        selectedFloor.setOccupiedFloor(inputCar);
        inputCar.startPark();
    }

    public synchronized void endProcess(Floor floor, Car car) {
        //calculate price
        //make payment
        //other steps
        double totalFare = floor.getTotalFare(car);
        System.out.println("car release with fare : "+ totalFare);
        floor.doReleaseFloor(car);
    }

}

