package com.example.part_1;

import java.util.*;

public class BingeIterator implements EpisodeIterator {
    private final Iterator<Season> seasonIterator;
    private EpisodeIterator current;

    public BingeIterator(List<Season> seasons) {
        this.seasonIterator = seasons.iterator();
        if (seasonIterator.hasNext()) {
            current = seasonIterator.next().getNormalIterator();
        }
    }

    @Override
    public boolean hasNext() {
        while ((current == null || !current.hasNext()) && seasonIterator.hasNext()) {
            current = seasonIterator.next().getNormalIterator();
        }
        return current != null && current.hasNext();
    }

    @Override
    public Episode next() {
        return current.next();
    }
}
