package com.example.part_2;

import java.util.List;

public interface RunwayScheduler {
    Aircraft selectNextAircraft(List<Aircraft> landingQueue, List<Aircraft> takeoffQueue);
}

