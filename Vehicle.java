package com.ParkingLot;

public class Vehicle {
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    // apis
    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
