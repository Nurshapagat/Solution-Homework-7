package com.example.part_2;

import java.util.Comparator;
import java.util.List;

public class FuelPriorityScheduler implements RunwayScheduler {

    @Override
    public Aircraft selectNextAircraft(List<Aircraft> landingQueue, List<Aircraft> takeoffQueue) {
        return landingQueue.stream()
                .min(Comparator.comparingInt(Aircraft::getFuelLevel))
                .orElse(null); // Егер ешкім жоқ болса — null
    }
}

