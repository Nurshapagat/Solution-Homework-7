package com.example.part_2;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;
    protected TowerMediator tower;

    public Aircraft(String id, int fuelLevel, TowerMediator tower) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.tower = tower;
        tower.registerAircraft(this);
    }

    public void send(String message) {
        tower.broadcast(message, this);
    }

    public abstract void receive(String message);

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}
