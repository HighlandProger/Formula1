package ua.com.foxminded.domain;

import java.util.Comparator;

public class RacerComparator implements Comparator<Racer> {

    @Override
    public int compare(Racer racer1, Racer racer2) {
        long time1 = racer1.getBestLapTime();
        long time2 = racer2.getBestLapTime();
        if (time1 == 0L) {
            return 1;
        }
        if (time2 == 0L) {
            return -1;
        }

        return Long.compare(time1, time2);
    }
}
