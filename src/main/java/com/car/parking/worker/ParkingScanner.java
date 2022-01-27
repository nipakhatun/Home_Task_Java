package com.car.parking.worker;



import com.car.parking.dao.ParkingFloorRepository;
import com.car.parking.model.Car;
import com.car.parking.model.Floor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingScanner {

    public void scanParkingFloor(Car car) {
        ParkingFloorRepository parkingFloorRepository = ParkingFloorRepository.getInstance();
        List<Floor> selectedFloor = parkingFloorRepository.getFloors()
                .stream()
                .filter(floor -> car.getHeight() <= floor.getHeight())
                .filter(floor -> car.getWeight() <= floor.getAvailableWeight())
                .sorted(Comparator.comparing(Floor::getCurrentUnitFactor))
                .collect(Collectors.toList());
        parkingFloorRepository.setSelectedFloor(selectedFloor.stream().findFirst().orElse(null));
    }
}
