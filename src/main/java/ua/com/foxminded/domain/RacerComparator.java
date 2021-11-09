package ua.com.foxminded.domain;

import java.util.Comparator;

public class RacerComparator implements Comparator<Racer> {

    @Override
    public int compare(Racer racer1, Racer racer2) {
        if (racer1.getBestLapTime() == 0 || racer2.getBestLapTime() == 0) {

            return -Long.compare(racer1.getBestLapTime(), racer2.getBestLapTime());
        }

        return Long.compare(racer1.getBestLapTime(), racer2.getBestLapTime());
    }
}
