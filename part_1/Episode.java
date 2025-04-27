package com.example.part_1;

public class Episode {
    private final String title;
    private final int runtimeSec;
    private boolean seen = false;

    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntimeSec() {
        return runtimeSec;
    }

    public boolean isSeen() {
        return seen;
    }

    public void markSeen() {
        this.seen = true;
    }

    @Override
    public String toString() {
        return title + " (" + runtimeSec + "s)" + (seen ? " [Seen]" : "");
    }
}