package com.example.part_1;

public class Main {
    public static void main(String[] args) {
        Series series = new Series();
        Season s1 = new Season();
        Season s2 = new Season();

        for (int i = 1; i <= 5; i++) {
            s1.addEpisode(new Episode("S1E" + i, 1000 + i * 10));
            s2.addEpisode(new Episode("S2E" + i, 1100 + i * 10));
        }

        series.addSeason(s1);
        series.addSeason(s2);

        System.out.println("-- WATCHING UNSEEN ONLY (WatchHistoryFilterIterator) --");
        EpisodeIterator filtered = new WatchHistoryFilterIterator(series.getBingeIterator());
        while (filtered.hasNext()) {
            Episode e = filtered.next();
            System.out.println("Watching: " + e);
            e.markSeen();
        }

        System.out.println("-- STRETCH GOAL: PERFORMANCE TEST --");
        Season bigSeason = new Season();
        for (int i = 0; i < 10_000; i++) {
            bigSeason.addEpisode(new Episode("Ep" + i, 1000));
        }

        measure("Normal", () -> {
            EpisodeIterator it = bigSeason.getNormalIterator();
            while (it.hasNext()) it.next();
        });

        measure("Reverse", () -> {
            EpisodeIterator it = bigSeason.getReverseIterator();
            while (it.hasNext()) it.next();
        });

        measure("Shuffle", () -> {
            EpisodeIterator it = bigSeason.getShuffleIterator(123);
            while (it.hasNext()) it.next();
        });
    }

    private static void measure(String label, Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        System.out.printf("%s Iterator Time: %d ms\n", label, (end - start));
    }
}
