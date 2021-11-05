package ua.com.foxminded.formatter;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.domain.Racer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataReaderTest {

    DataReader dataReader = new DataReader();

    @Test
    void getRacers_shouldReturnListOfRacers() {

        List<Racer> expectedRacers = new ArrayList<>();
        expectedRacers.add(new Racer("SVF", "Sebastian Vettel", "FERRARI", 64415));
        expectedRacers.add(new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", 72013));
        expectedRacers.add(new Racer("VBM", "Valtteri Bottas", "MERCEDES", 72434));
        expectedRacers.add(new Racer("LHM", "Lewis Hamilton", "MERCEDES", 72460));
        expectedRacers.add(new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", 72463));

        List<Racer> actualRacers = dataReader.getRacers().stream().limit(5).collect(Collectors.toList());

        assertEquals(expectedRacers, actualRacers);
    }
}
