package ua.com.foxminded.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Racer {

    private final String abbreviation;
    private final String name;
    private final String team;
    private List<Date> startTimes;
    private List<Date> endTimes;

    public Racer(String abbreviation, String name, String team) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.team = team;
    }

    public long getBestLapTime() {

        if (startTimes.isEmpty() || endTimes.isEmpty()) {
            return 0;
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        List<Long> lapTimes = new ArrayList<>();
        for (int i = 0; i < endTimes.size(); i++) {
            long endTime = endTimes.get(i).getTime();
            long startTime = startTimes.get(i).getTime();
            lapTimes.add(endTime - startTime);
        }

        return Collections.min(lapTimes);
    }

    public void setStartTimes(List<Date> startLapTimes) {
        this.startTimes = startLapTimes;
    }

    public void setEndTimes(List<Date> endLapTimes) {
        this.endTimes = endLapTimes;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

}
