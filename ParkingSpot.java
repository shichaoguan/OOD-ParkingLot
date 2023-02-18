package com.ParkingLot;

public class ParkingSpot {
    private VehicleType vehicleType;
    private Vehicle parkedCar;


    public ParkingSpot(VehicleType vehicleType) {

        this.vehicleType = vehicleType;

    }

    public boolean tryParkVehicle(Vehicle vehicle) {

        if (this.parkedCar == null && vehicleType == vehicle.getVehicleType()) {
            this.parkedCar = vehicle;
            return true;
        }
        return false;
    }

    public boolean tryRemoveVehicle(Vehicle vehicle) {
        if (this.parkedCar == vehicle) {
            parkedCar = null;
            return true;
        }
        return false;
    }
}
