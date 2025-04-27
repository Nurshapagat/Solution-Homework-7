package com.example.part_2;

import java.util.*;
import java.util.concurrent.*;

public class AirportSimulation {
    public static void main(String[] args) throws InterruptedException {
        RunwayScheduler scheduler = new FuelPriorityScheduler();
        ControlTower tower = new ControlTower(scheduler);

        List<Aircraft> fleet = new ArrayList<>();
        Random rand = new Random();

        // Generate 10 random aircrafts
        for (int i = 0; i < 10; i++) {
            int fuel = rand.nextInt(100);
            String id = "A" + (i + 1);
            Aircraft a;
            switch (rand.nextInt(3)) {
                case 0 -> a = new PassengerPlane(id, fuel, tower);
                case 1 -> a = new CargoPlane(id, fuel, tower);
                default -> a = new Helicopter(id, fuel, tower);
            }
            fleet.add(a);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            Aircraft a = fleet.get(rand.nextInt(fleet.size()));
            if (a.getFuelLevel() < 10) {
                a.send("MAYDAY");
            } else {
                if (rand.nextBoolean()) {
                    a.send("REQUEST LANDING");
                } else {
                    a.send("REQUEST TAKEOFF");
                }
            }
            tower.printQueueStatus();
        }, 0, 2, TimeUnit.SECONDS);

        // Allow runway access loop
        ScheduledExecutorService runway = Executors.newScheduledThreadPool(1);
        runway.scheduleAtFixedRate(() -> {
            for (Aircraft a : fleet) {
                if (tower.requestRunway(a)) {
                    System.out.println("[SIMULATION] " + a + " used the runway.");
                    tower.freeRunway();
                    break;
                }
            }
        }, 1, 3, TimeUnit.SECONDS);

        Thread.sleep(20000); // Let simulation run for 20 seconds
        executor.shutdown();
        runway.shutdown();
    }
}
