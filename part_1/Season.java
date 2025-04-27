package com.example.part_1;

import java.util.*;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public EpisodeIterator getNormalIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator getReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator getShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(episodes);
    }
}