package ua.com.foxminded.formatter;

import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.util.DateUtils;

import java.util.List;
import java.util.NoSuchElementException;

public class QualificationTableFormatter {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = " | ";
    private static final String DASH = "-";
    private static final int TOP_RACERS_COUNT = 15;
    private static final int MAX_SERIAL_NUMBER_AND_DELIMITER_SYMBOLS_COUNT = 19;
    private int maxTeamFieldSymbolsSize;
    private int topRacersUnderlineDashesCount;

    public String format(List<Racer> racers) {

        maxTeamFieldSymbolsSize = getMaxTeamFieldSymbolsSize(racers);
        topRacersUnderlineDashesCount = getTopRacersUnderlineDashesCount(racers);

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

    private String repeatSymbols(String symbol, int count) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(symbol);
        }

        return builder.toString();
    }

    private String getTeamFieldExtraSpaces(String teamName) {
        return repeatSymbols(SPACE, maxTeamFieldSymbolsSize - teamName.length());
    }

    private String getTopRacersDashesString() {
        return repeatSymbols(DASH, topRacersUnderlineDashesCount);
    }

    private int getTopRacersUnderlineDashesCount(List<Racer> racers) {

        int maxNameAndTeamFieldsSymbolsSize = racers
            .stream()
            .mapToInt(el -> el.getName().length() + el.getTeam().length())
            .max()
            .orElseThrow(NoSuchElementException::new);

        return maxNameAndTeamFieldsSymbolsSize + MAX_SERIAL_NUMBER_AND_DELIMITER_SYMBOLS_COUNT;
    }

    private int getMaxTeamFieldSymbolsSize(List<Racer> racers) {

        return racers
            .stream()
            .mapToInt(row -> row.getTeam().length())
            .max()
            .orElseThrow(NoSuchElementException::new);
    }

}
