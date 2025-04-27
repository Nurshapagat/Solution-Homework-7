package com.example.part_1;

import java.util.*;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private final Iterator<Episode> iterator;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        shuffled = new ArrayList<>(episodes);
        Collections.shuffle(shuffled, new Random(seed));
        iterator = shuffled.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Episode next() {
        return iterator.next();
    }
}