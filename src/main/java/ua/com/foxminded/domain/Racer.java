package ua.com.foxminded.domain;

import java.util.Objects;

public class Racer {

    private final String abbreviation;
    private final String name;
    private final String team;
    private final long bestLapTime;

    public Racer(String abbreviation, String name, String team, long bestLapTime) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.team = team;
        this.bestLapTime = bestLapTime;
    }

    public long getBestLapTime() {
        return bestLapTime;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Racer{" +
            "abbreviation='" + abbreviation + '\'' +
            ", name='" + name + '\'' +
            ", team='" + team + '\'' +
            ", bestLapTime=" + bestLapTime +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Racer)) return false;
        Racer racer = (Racer) o;
        return bestLapTime == racer.bestLapTime &&
            abbreviation.equals(racer.abbreviation) &&
            name.equals(racer.name) &&
            team.equals(racer.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, name, team, bestLapTime);
    }
}
