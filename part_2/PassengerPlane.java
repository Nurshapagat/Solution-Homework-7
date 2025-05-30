package com.example.part_2;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuelLevel, TowerMediator tower) {
        super(id, fuelLevel, tower);
    }

    @Override
    public void receive(String message) {
        System.out.println("[PassengerPlane " + id + "] Received: " + message);
    }
}

