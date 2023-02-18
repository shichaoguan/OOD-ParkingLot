package com.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // building displayboard
        Map<VehicleType, Integer> spotMap = new HashMap<>(); // {car, 4; truck, 3; motorcycle, 2}
        spotMap.put(VehicleType.CAR, 4);
        spotMap.put(VehicleType.TRUCK, 3);
        spotMap.put(VehicleType.MOTORCYCLE, 2);
        DisplayBoard displayBoard = new DisplayBoard(spotMap);

        // building parkign lot
        ParkingSpot spot1 = new ParkingSpot(VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot(VehicleType.CAR);
        ParkingSpot spot3 = new ParkingSpot(VehicleType.TRUCK);
        List<ParkingSpot> spotList = new ArrayList<>();
        spotList.add(spot1);
        spotList.add(spot2);
        ParkingFloor floor1 = new ParkingFloor(spotList);
        spotList.add(spot3);
        ParkingFloor floor2 = new ParkingFloor(spotList);

        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(floor1);
        parkingFloorList.add(floor2);

        double flatRate = 2.5;
        ParkingLot parkingLot = new ParkingLot(parkingFloorList, displayBoard, flatRate);

        Customer customer = new Customer(new Car(), new Payment(100));
        customer.tryParkVehicle(parkingLot);
        System.out.println("I parked my car and going shopping");
        sleep(2000);
        customer.tryRemoveVehicle(parkingLot);
        System.out.println("Customer's moneyleft: " + customer.getPayment().getTotalMoney());
    }


}
