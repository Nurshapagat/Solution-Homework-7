package com.example.part_1;

public class WatchHistoryFilterIterator implements EpisodeIterator {
    private final EpisodeIterator baseIterator;
    private Episode nextItem;

    public WatchHistoryFilterIterator(EpisodeIterator baseIterator) {
        this.baseIterator = baseIterator;
        advance();
    }

    private void advance() {
        nextItem = null;
        while (baseIterator.hasNext()) {
            Episode candidate = baseIterator.next();
            if (!candidate.isSeen()) {
                nextItem = candidate;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextItem != null;
    }

    @Override
    public Episode next() {
        Episode result = nextItem;
        advance();
        return result;
    }
}
