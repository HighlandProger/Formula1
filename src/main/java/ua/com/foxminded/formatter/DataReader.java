package ua.com.foxminded.formatter;

import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.domain.RacerComparator;
import ua.com.foxminded.exception.DataReadException;
import ua.com.foxminded.util.DateUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private List<String> startLapTimes;
    private List<String> endLapTimes;

    public List<Racer> getRacers(String startLog, String endLog, String abbreviations) {

        List<Racer> racerList = new ArrayList<>();

        startLapTimes = getDataFromFile(startLog);
        endLapTimes = getDataFromFile(endLog);
        List<String> racersData = getDataFromFile(abbreviations);
        racersData.forEach(row -> {
            String[] racerData = row.split("_");
            Racer racer = new Racer(racerData[0], racerData[1], racerData[2], calculateBestLapTime(racerData[0]));
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

    private long calculateBestLapTime(String abbreviation) {

        List<Date> racerStartTimes = getTimePointsByAbbreviation(startLapTimes, abbreviation);
        List<Date> racerEndTimes = getTimePointsByAbbreviation(endLapTimes, abbreviation);

        if (racerStartTimes.isEmpty() || racerEndTimes.isEmpty()) {
            return 0;
        }

        Collections.sort(racerStartTimes);
        Collections.sort(racerEndTimes);

        List<Long> lapTimes = new ArrayList<>();
        for (int i = 0; i < racerEndTimes.size(); i++) {
            long endTime = racerEndTimes.get(i).getTime();
            long startTime = racerStartTimes.get(i).getTime();
            lapTimes.add(endTime - startTime);
        }

        return Collections.min(lapTimes);
    }

    private List<Date> getTimePointsByAbbreviation(List<String> timePoints, String abbreviation) {

        return timePoints
            .stream()
            .filter(el -> el.startsWith(abbreviation))
            .map(logString -> DateUtils.getDateFromString(logString.substring(3)))
            .collect(Collectors.toList());

    }

}
