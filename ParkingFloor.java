package com.ParkingLot;

import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpotList;

    public ParkingFloor(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public boolean tryParkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if (spot.tryParkVehicle(vehicle)) {// parked car;
                return true;
            }
        }
        return false;
    }

    public boolean tryRemoveVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpotList) {
            if (spot.tryRemoveVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

}
