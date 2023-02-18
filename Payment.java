package com.ParkingLot;

public class Payment {
    private double totalMoney;

    public Payment(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public boolean handlePayment(Ticket ticket, Payment payment, double price) {

        System.out.println("price: " + this.totalMoney);
        if (totalMoney >= price) {
            totalMoney -= price; // pass by value?
            System.out.println("reducing price " + totalMoney);
            return true;
        }
        return false;
    }
}
