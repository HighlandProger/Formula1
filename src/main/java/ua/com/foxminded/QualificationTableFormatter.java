package ua.com.foxminded;

import java.util.List;

public class QualificationTableFormatter {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = " | ";
    private static final String DASH = "-";
    private static final int TOP_RACERS_COUNT = 15;
    private static final int MIN_TEAM_FIELD_SYMBOLS_SIZE = 25;
    private static final int TOP_RACERS_UNDERLINE_DASHES_COUNT = 30;

    public String format(List<Racer> racers) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < racers.size(); i++) {

            if (i == TOP_RACERS_COUNT) {
                builder
                    .append(getTopRacersDashesString())
                    .append(NEW_LINE);
            }

            Racer racer = racers.get(i);

            builder
                .append(i + 1)
                .append(". ")
                .append(racer.getName())
                .append(DELIMITER)
                .append(racer.getTeam())
                .append(getTeamFieldExtraSpaces(racer.getTeam()))
                .append(DELIMITER)
                .append(DateUtils.formatTime(racer.getBestLapTime()))
                .append(NEW_LINE);
        }

        return builder.toString();
    }

    private String repeatSymbols(String symbol, int count){

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(symbol);
        }

        return builder.toString();
    }

    private String getTeamFieldExtraSpaces(String teamName) {
        return repeatSymbols(SPACE, MIN_TEAM_FIELD_SYMBOLS_SIZE - teamName.length());
    }

    private String getTopRacersDashesString() {
        return repeatSymbols(DASH, TOP_RACERS_UNDERLINE_DASHES_COUNT);
    }

}
