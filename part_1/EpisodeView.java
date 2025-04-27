package com.example.part_1;

public class EpisodeView extends Episode {
    private final int skipStart;

    public EpisodeView(Episode base, int skipStart) {
        super(base.getTitle(), base.getRuntimeSec());
        this.skipStart = skipStart;
    }

    public void play() {
        System.out.println("Playing from " + skipStart + "s: " + getTitle());
    }
}