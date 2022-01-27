package com.car.parking.dao;
import com.car.parking.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloorRepository {
    private final List<Floor> floors = new ArrayList<>();
    private Floor selectedFloor;

    private ParkingFloorRepository() {
        init();
    }

    private static class InitializeRestCaller {
        private static final ParkingFloorRepository REPOSITORY = new ParkingFloorRepository();
    }

    public synchronized static ParkingFloorRepository getInstance() {
        return InitializeRestCaller.REPOSITORY;
    }

    private void init() {
        floors.add(new Floor( 10, 200));
        floors.add(new Floor( 5.5, 130));
        floors.add(new Floor( 6, 78.2));
        floors.add(new Floor( 6.8, 25.2));
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setSelectedFloor(Floor floor) {
        selectedFloor = floor;
    }

    public Floor getSelectedFloor() {
        return selectedFloor;
    }

}
