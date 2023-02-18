package com.ParkingLot;

public class Customer {

    private Vehicle vehicle;
    private Ticket ticket;
    private Payment payment;

    public Customer(Vehicle vehicle, Payment payment) {
        this.vehicle = vehicle;
        this.payment = payment;
    }

    // apis:
    public void tryParkVehicle(ParkingLot parkingLot) {
        this.ticket = parkingLot.tryParkVehicle(this.vehicle);
    }

    public void tryRemoveVehicle(ParkingLot parkingLot) {
        parkingLot.tryRemoveVehicle(this.vehicle, ticket, payment);

    }

    public Payment getPayment() {
        return this.payment;
    }
}
