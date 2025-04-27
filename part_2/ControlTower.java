package com.example.part_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ControlTower implements TowerMediator {

    private List<Aircraft> allAircraft = new ArrayList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private List<Aircraft> landingQueue = new ArrayList<>();
    private RunwayScheduler scheduler;

    private boolean isRunwayFree = true;

    public ControlTower(RunwayScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void broadcast(String message, Aircraft sender) {
        if (message.equalsIgnoreCase("MAYDAY")) {
            System.out.println("[TOWER] EMERGENCY: " + sender + " requesting immediate landing!");

            // Барлыққа хабар жіберу
            for (Aircraft aircraft : allAircraft) {
                if (aircraft != sender) {
                    aircraft.receive("Hold position: Emergency landing for " + sender);
                }
            }

            // Жолақты босату
            landingQueue.remove(sender);
            takeoffQueue.remove(sender);

            // Бірден рұқсат беру
            System.out.println("[TOWER] Runway granted IMMEDIATELY to " + sender);
            isRunwayFree = false;

        } else if (message.equalsIgnoreCase("REQUEST LANDING")) {
            System.out.println("[TOWER] " + sender + " requested landing.");
            landingQueue.add(sender);
        } else if (message.equalsIgnoreCase("REQUEST TAKEOFF")) {
            System.out.println("[TOWER] " + sender + " requested takeoff.");
            takeoffQueue.add(sender);
        }
    }

    @Override
    public boolean requestRunway(Aircraft aircraft) {
        if (!isRunwayFree) return false;

        Aircraft next = scheduler.selectNextAircraft(landingQueue, (List<Aircraft>) takeoffQueue);
        if (aircraft == next) {
            System.out.println("[TOWER] Runway granted to " + aircraft);
            isRunwayFree = false;

            // Кезектен алып тастаймыз
            landingQueue.remove(aircraft);
            takeoffQueue.remove(aircraft);
            return true;
        }
        return false;
    }

    @Override
    public void registerAircraft(Aircraft aircraft) {
        allAircraft.add(aircraft);
    }

    public void freeRunway() {
        isRunwayFree = true;
    }

    public void printQueueStatus() {
        System.out.println("[TOWER] Landing queue: " + landingQueue);
        System.out.println("[TOWER] Takeoff queue: " + takeoffQueue);
    }
}
