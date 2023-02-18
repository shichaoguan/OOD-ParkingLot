package com.ParkingLot;
/*
parking lot should have:
parking lot has a parking floor;
parking floor has a parking spot;
parking spot can park car;
vehicle has multi type: car, truck, motorcycle;
parking spot has multi type: car, truck, motorcycle;

parking lot has displayBoard for showing how many spot available for each type of car;
parking lot has a ticket to let people pay when it left car;

user should be able to:
parking the car if available;
pay for the ticket;
move the car;
*
Entity: parking lot, parking floor, parking spot, vehicle, different type of sport and vehicle, display board, ticket, customer;
**/


import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private List<ParkingFloor> parkingFloorList;
    private DisplayBoard displayBoard;
    private double flatRate;

    public ParkingLot(List<ParkingFloor> parkingFloorList, DisplayBoard displayBoard, double flatRate) {
        this.parkingFloorList = parkingFloorList;
        this.displayBoard = displayBoard;
        this.flatRate = flatRate;
    }

    // apis:
        // parking vehicle
    public Ticket tryParkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloorList) {
            if (floor.tryParkVehicle(vehicle) ) { // parked car
                displayBoard.tryParkVehicle(vehicle.getVehicleType());
                return new Ticket();
            }
        }
        return null;
    }

    public void tryRemoveVehicle(Vehicle vehicle, Ticket ticket, Payment payment) {
        for (ParkingFloor floor : parkingFloorList) {
            if (floor.tryRemoveVehicle(vehicle)) {
                displayBoard.tryRemoveVehicle(vehicle.getVehicleType());
                double price = getPrice(ticket, this.flatRate);
                if (payment.handlePayment(ticket, payment, price) ) {
                    ticket = null;
                }

            }
        }
    }

    private double getPrice(Ticket ticket, double flatRate) {
        long startTime = ticket.getStartTime();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        // convert to seconds
        long totalSecs = TimeUnit.NANOSECONDS.
                toSeconds(elapsedTime);
        // double hours = totalSecs / 3600;


        System.out.println("TotalHours: " + totalSecs);
        return totalSecs * flatRate;

    }


    // remove vehicle
    /* singleton: 1 parkinglot only, don't let other ppl new;
    private static ParkingLot parkingLot = null;
    private ParkingLot () {
    }
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    */
}




