package ua.com.foxminded;

import java.util.Comparator;

public class RacerComparator implements Comparator<Racer> {

    @Override
    public int compare(Racer racer1, Racer racer2) {
        return racer1.getBestLapTime().compareTo(racer2.getBestLapTime());
    }
}
