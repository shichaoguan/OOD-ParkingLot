package com.ParkingLot;

public class Ticket {
    private long startTime;


    public Ticket() {
        this.startTime = System.nanoTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

}
