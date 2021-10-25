package ua.com.foxminded;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataReader {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String ABBREVIATIONS = "abbreviations.txt";
    private static final String START = "start.log";
    private static final String END = "end.log";

    private final DateFormatter dateFormatter = new DateFormatter();

    public List<Racer> getRacersList() {

        List<Racer> racers = new ArrayList<>();
        List<String> racersData = getStringsFromAbbreviationsFile();

        racersData.forEach(el -> {
            String[] racerData = el.split("_");
            Racer racer = new Racer(racerData[0], racerData[1], racerData[2]);
            racer.setBestLapTime(getTimeByAbbreviation(racer.getAbbreviation()));
            racers.add(racer);
        });
        return racers;
    }

    private List<String> getStringsFromAbbreviationsFile() {
        return getDataFromFile(ABBREVIATIONS);
    }

    private List<String> getStringsFromStartFile() {
        return getDataFromFile(START);
    }

    private List<String> getStringsFromEndFile() {
        return getDataFromFile(END);
    }

    private List<String> getDataFromFile(String fileName) {

        List<String> data = new ArrayList<>();
        String filePath = RESOURCES_PATH + fileName;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                data.add(fileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String getTimeByAbbreviation(String abbreviation) {

        String startTime = getStringsFromStartFile()
            .stream()
            .filter(el -> el.startsWith(abbreviation))
            .findFirst()
            .orElseThrow(NoSuchElementException::new);

        String endTime = getStringsFromEndFile()
            .stream()
            .filter(el -> el.startsWith(abbreviation))
            .findFirst()
            .orElseThrow(NoSuchElementException::new);

        return dateFormatter.getTimeDifference(startTime, endTime);
    }

}