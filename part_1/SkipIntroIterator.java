package com.example.part_1;

public class SkipIntroIterator implements EpisodeIterator {
    private final EpisodeIterator baseIterator;
    private final int skipSeconds;

    public SkipIntroIterator(EpisodeIterator baseIterator, int skipSeconds) {
        this.baseIterator = baseIterator;
        this.skipSeconds = skipSeconds;
    }

    @Override
    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    @Override
    public Episode next() {
        Episode ep = baseIterator.next();
        return new EpisodeView(ep, skipSeconds);
    }
}