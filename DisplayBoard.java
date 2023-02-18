package com.ParkingLot;

import java.util.Map;

public class DisplayBoard {
    // private VehicleType vehicleType;
    private Map<VehicleType, Integer> typeSpotLeft;


    public DisplayBoard(Map<VehicleType, Integer> typeSpotLeft) {
        this.typeSpotLeft = typeSpotLeft;
    }

    // apis
    public void tryParkVehicle(VehicleType vehicleType) {
        int count = typeSpotLeft.get(vehicleType);
        count--;
        typeSpotLeft.put(vehicleType, count);
    }

    public void tryRemoveVehicle(VehicleType vehicleType) {
        int count = typeSpotLeft.get(vehicleType);
        count++;
        typeSpotLeft.put(vehicleType, count);
    }



}
