package com.example.part_2;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, int fuelLevel, TowerMediator tower) {
        super(id, fuelLevel, tower);
    }

    @Override
    public void receive(String message) {
        System.out.println("[PassengerPlane " + id + "] Received: " + message);
    }
}
