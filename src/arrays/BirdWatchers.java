package arrays;

import java.util.Arrays;

public class BirdWatchers {
    private int[] birdsPerDay;
    private final int[] birdsLastWeek = {0, 2, 5, 3, 7, 8, 4};

    public void BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public BirdWatchers(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    public int[] getLastWeek() {
        return birdsLastWeek;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[birdsPerDay.length-1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay).filter(s -> s == 0).sum() >= 1;
    }

    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(birdsPerDay).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay).filter(x -> x >= 5).count();
    }
}