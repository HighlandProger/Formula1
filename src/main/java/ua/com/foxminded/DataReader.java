package ua.com.foxminded;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataReader {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String ABBREVIATIONS_FILE = "abbreviations.txt";
    private static final String START_LOG = "start.log";
    private static final String END_LOG = "end.log";

    private List<String> startLapTimes;
    private List<String> endLapTimes;

    public List<Racer> getRacersList() {

        List<Racer> racers = new ArrayList<>();
        List<String> racersData = getDataFromFile(ABBREVIATIONS_FILE);

        startLapTimes = getDataFromFile(START_LOG);
        endLapTimes = getDataFromFile(END_LOG);

        racersData.forEach(el -> {
            String[] racerData = el.split("_");
            Racer racer = new Racer(racerData[0], racerData[1], racerData[2]);
            racer.setBestLapTime(getTimeByAbbreviation(racer.getAbbreviation()));
            racers.add(racer);
        });

        racers.sort(new RacerComparator());

        return racers;
    }

    private List<String> getDataFromFile(String fileName) {

        List<String> data = new ArrayList<>();
        String filePath = RESOURCES_PATH + fileName;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                data.add(fileReader.readLine());
            }
        } catch (IOException e) {
            throw new DataReaderException("Cannot read " + fileName + ". Check file name");
        }

        return data;
    }

    private long getTimeByAbbreviation(String abbreviation) {

        String startTime = startLapTimes
            .stream()
            .filter(el -> el.startsWith(abbreviation))
            .findFirst()
            .map(logString -> new StringBuilder(logString).substring(3))
            .orElseThrow(NoSuchElementException::new);

        String endTime = endLapTimes
            .stream()
            .filter(el -> el.startsWith(abbreviation))
            .findFirst()
            .map(logString -> new StringBuilder(logString).substring(3))
            .orElseThrow(NoSuchElementException::new);

        return DateUtils.getTimeDifference(startTime, endTime);
    }

}
