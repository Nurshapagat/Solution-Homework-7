package com.example.part_2;

public interface TowerMediator {
    void broadcast(String message, Aircraft sender);
    boolean requestRunway(Aircraft aircraft);
    void registerAircraft(Aircraft aircraft);
}
