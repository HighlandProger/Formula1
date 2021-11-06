package ua.com.foxminded.formatter;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.exception.DataReadException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataReaderTest {

    private static final String ROOT_FOLDER_PATH = "";
    private static final String EMPTY_FOLDER_PATH = "testcase1/";
    private static final String ONLY_ABBREVIATIONS_FOLDER_PATH = "testcase2/";
    private static final String ONE_MANY_LOGS_FOR_RACES_FOLDER_PATH = "testcase3/";
    private static final String START_LOG = "start.log";
    private static final String END_LOG = "end.log";
    private static final String ABBREVIATIONS = "abbreviations.txt";
    private final DataReader dataReader = new DataReader();
    private final QualificationTableFormatterTest qualificationTableFormatterTest = new QualificationTableFormatterTest();
    private String startLog;
    private String endLog;
    private String abbreviations;
    private List<Racer> expectedRacers;
    private List<Racer> actualRacers;

    @Test
    void getRacers() {

        setFolderPath(ROOT_FOLDER_PATH);

        expectedRacers = qualificationTableFormatterTest.racers;
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

        setFolderPath(ONE_MANY_LOGS_FOR_RACES_FOLDER_PATH);

        List<Racer> racers = new ArrayList<>();
        racers.add(new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", 55158));
        racers.add(new Racer("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES", 55443));
        racers.add(new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", 63647));
        racers.add(new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", 78389));
        racers.add(new Racer("SPF", "Sergio Perez", "FORCE INDIA MERCEDES", 80737));
        racers.add(new Racer("RGH", "Romain Grosjean", "HAAS FERRARI", 100987));
        racers.add(new Racer("CSR", "Carlos Sainz", "RENAULT", 105372));
        racers.add(new Racer("MES", "Marcus Ericsson", "SAUBER FERRARI", 110423));
        racers.add(new Racer("KRF", "Kimi Raikkonen", "FERRARI", 123454));
        racers.add(new Racer("KMH", "Kevin Magnussen", "HAAS FERRARI", 133796));
        racers.add(new Racer("NHR", "Nico Hulkenberg", "RENAULT", 135147));
        racers.add(new Racer("FAM", "Fernando Alonso", "MCLAREN RENAULT", 163965));
        racers.add(new Racer("LSW", "Lance Stroll", "WILLIAMS MERCEDES", 180087));
        racers.add(new Racer("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES", 180247));
        racers.add(new Racer("CLS", "Charles Leclerc", "SAUBER FERRARI", 180257));
        racers.add(new Racer("LHM", "Lewis Hamilton", "MERCEDES", 180462));
        racers.add(new Racer("VBM", "Valtteri Bottas", "MERCEDES", 180472));
        racers.add(new Racer("SVF", "Sebastian Vettel", "FERRARI", 180745));
        racers.add(new Racer("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", 180845));

        expectedRacers = racers;
        actualRacers = dataReader.getRacers(startLog, endLog, abbreviations);

        assertEquals(expectedRacers, actualRacers);
    }

    private void setFolderPath(String folderPath) {
        this.startLog = folderPath + START_LOG;
        this.endLog = folderPath + END_LOG;
        this.abbreviations = folderPath + ABBREVIATIONS;
    }

}
