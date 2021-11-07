package ua.com.foxminded.formatter;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.exception.DataReadException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataReaderTest {

    private static final String ROOT_FOLDER_PATH = "";
    private static final String EMPTY_FOLDER_PATH = "testcase1/";
    private static final String ONLY_ABBREVIATIONS_FOLDER_PATH = "testcase2/";
    private static final String TWO_OR_MANY_LOGS_FOR_RACES_FOLDER_PATH = "testcase3/";
    private static final String START_LOG = "start.log";
    private static final String END_LOG = "end.log";
    private static final String ABBREVIATIONS = "abbreviations.txt";
    private final DataReader dataReader = new DataReader();
    private String startLog;
    private String endLog;
    private String abbreviations;
    private List<Racer> expectedRacers;
    private List<Racer> actualRacers;

    @Test
    void getRacers() {

        setFolderPath(ROOT_FOLDER_PATH);

        expectedRacers = TestUtils.getDefaultRacers();
        actualRacers = dataReader.getRacers(startLog, endLog, abbreviations);

        assertEquals(expectedRacers, actualRacers);
    }

    @Test
    void getRacers_shouldThrowDataReadException_whenFolderIsEmpty() {

        setFolderPath(EMPTY_FOLDER_PATH);

        Exception exception = assertThrows(DataReadException.class,
            () -> dataReader.getRacers(startLog, endLog, abbreviations));

        String expectedExceptionString = "Cannot read testcase1/start.log. Check file name";
        String actualExceptionString = exception.getMessage();

        assertEquals(expectedExceptionString, actualExceptionString);
    }

    @Test
    void getRacers_shouldThrowDataReadException_whenFolderContainsOnlyAbbreviations() {

        setFolderPath(ONLY_ABBREVIATIONS_FOLDER_PATH);

        Exception exception = assertThrows(DataReadException.class,
            () -> dataReader.getRacers(startLog, endLog, abbreviations));

        String expectedExceptionString = "Cannot read testcase2/start.log. Check file name";
        String actualExceptionString = exception.getMessage();

        assertEquals(expectedExceptionString, actualExceptionString);
    }

    @Test
    void getRacers_shouldReturnRacersWithBestLapTime_whenLogFilesContainsMoreThanOneTimePointsForRacer() {

        setFolderPath(TWO_OR_MANY_LOGS_FOR_RACES_FOLDER_PATH);

        expectedRacers = TestUtils.getRacersWithManyTimePoints();
        actualRacers = dataReader.getRacers(startLog, endLog, abbreviations);

        assertEquals(expectedRacers, actualRacers);
    }

    private void setFolderPath(String folderPath) {

        this.startLog = folderPath + START_LOG;
        this.endLog = folderPath + END_LOG;
        this.abbreviations = folderPath + ABBREVIATIONS;
    }

}
