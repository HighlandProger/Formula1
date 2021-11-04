package ua.com.foxminded.formatter;

import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.domain.RacerComparator;
import ua.com.foxminded.exception.DataReadException;
import ua.com.foxminded.util.DateUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String ABBREVIATIONS_FILE = "abbreviations.txt";
    private static final String START_LOG = "start.log";
    private static final String END_LOG = "end.log";

    public List<Racer> getRacers() {

        List<Racer> racerList = new ArrayList<>();

        List<String> startLapTimes = getDataFromFile(START_LOG);
        List<String> endLapTimes = getDataFromFile(END_LOG);
        List<String> racersData = getDataFromFile(ABBREVIATIONS_FILE);
        racersData.forEach(row -> {
            String[] racerData = row.split("_");
            Racer racer = new Racer(racerData[0], racerData[1], racerData[2]);
            racer.setStartTimes(getLapTimes(startLapTimes, racer.getAbbreviation()));
            racer.setEndTimes(getLapTimes(endLapTimes, racer.getAbbreviation()));
            racerList.add(racer);
        });

        racerList.sort(new RacerComparator());

        return racerList;
    }

    private List<String> getDataFromFile(String fileName) {

        List<String> data = new ArrayList<>();
        String filePath = RESOURCES_PATH + fileName;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                data.add(fileReader.readLine());
            }
        } catch (IOException e) {
            throw new DataReadException("Cannot read " + fileName + ". Check file name");
        }

        return data;
    }

    private List<Date> getLapTimes(List<String> lapTimes, String abbreviation) {
        return getTimePointsByAbbreviation(lapTimes, abbreviation);
    }

    private List<Date> getTimePointsByAbbreviation(List<String> timePoints, String abbreviation) {

        return timePoints
            .stream()
            .filter(el -> el.startsWith(abbreviation))
            .map(logString -> DateUtils.getDateFromString(logString.substring(3)))
            .collect(Collectors.toList());

    }

}
