package ua.com.foxminded;

import java.util.List;

public class StringFormatter {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = " | ";

    private final RacerComparator racerComparator = new RacerComparator();

    public String getFormattedString(List<Racer> racers) {

        StringBuilder builder = new StringBuilder();

        racers.sort(racerComparator);

        for (int i = 0; i < racers.size(); i++) {

            if (i == 15) {
                builder
                    .append("---------------------------------------------")
                    .append("\n");
            }

            Racer racer = racers.get(i);

            builder
                .append(i + 1)
                .append(". ")
                .append(racer.getName())
                .append(DELIMITER)
                .append(racer.getCommand())
                .append(getExtraSpaces(racer.getCommand()))
                .append(DELIMITER)
                .append(racer.getBestLapTime())
                .append(NEW_LINE);
        }

        return builder.toString();
    }

    private String getExtraSpaces(String word) {
        StringBuilder builder = new StringBuilder(SPACE);
        int symbolCount = word.length();

        while (symbolCount < 25) {
            symbolCount++;
            builder.append(SPACE);
        }

        return builder.toString();
    }
}
