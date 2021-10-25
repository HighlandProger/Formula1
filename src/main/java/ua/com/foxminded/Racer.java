package ua.com.foxminded;

public class Racer {

    private final String abbreviation;
    private final String name;
    private final String command;
    private String bestLapTime;

    public Racer(String abbreviation, String name, String command) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.command = command;
    }

    public void setBestLapTime(String bestLapTime) {
        this.bestLapTime = bestLapTime;
    }

    public String getBestLapTime() {
        return bestLapTime;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

}
