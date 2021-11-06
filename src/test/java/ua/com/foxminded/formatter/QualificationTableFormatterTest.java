package ua.com.foxminded.formatter;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.domain.Racer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualificationTableFormatterTest {

    protected final List<Racer> racers = new ArrayList<>();
    private final QualificationTableFormatter formatter = new QualificationTableFormatter();
    private String expectedString;
    private String actualString;

    {
        racers.add(new Racer("SVF", "Sebastian Vettel", "FERRARI", 64415));
        racers.add(new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", 72013));
        racers.add(new Racer("VBM", "Valtteri Bottas", "MERCEDES", 72434));
        racers.add(new Racer("LHM", "Lewis Hamilton", "MERCEDES", 72460));
        racers.add(new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", 72463));
        racers.add(new Racer("KRF", "Kimi Raikkonen", "FERRARI", 72639));
        racers.add(new Racer("FAM", "Fernando Alonso", "MCLAREN RENAULT", 72657));
        racers.add(new Racer("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES", 72706));
        racers.add(new Racer("CLS", "Charles Leclerc", "SAUBER FERRARI", 72829));
        racers.add(new Racer("SPF", "Sergio Perez", "FORCE INDIA MERCEDES", 72848));
        racers.add(new Racer("RGH", "Romain Grosjean", "HAAS FERRARI", 72930));
        racers.add(new Racer("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", 72941));
        racers.add(new Racer("CSR", "Carlos Sainz", "RENAULT", 72950));
        racers.add(new Racer("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES", 73028));
        racers.add(new Racer("NHR", "Nico Hulkenberg", "RENAULT", 73065));
        racers.add(new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", 73179));
        racers.add(new Racer("MES", "Marcus Ericsson", "SAUBER FERRARI", 73265));
        racers.add(new Racer("LSW", "Lance Stroll", "WILLIAMS MERCEDES", 73323));
        racers.add(new Racer("KMH", "Kevin Magnussen", "HAAS FERRARI", 73393));
    }

    @Test
    void format() {

        actualString = formatter.format(racers);
        expectedString =
            "1. Sebastian Vettel | FERRARI                   | 01:04.415\n" +
                "2. Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013\n" +
                "3. Valtteri Bottas | MERCEDES                  | 01:12.434\n" +
                "4. Lewis Hamilton | MERCEDES                  | 01:12.460\n" +
                "5. Stoffel Vandoorne | MCLAREN RENAULT           | 01:12.463\n" +
                "6. Kimi Raikkonen | FERRARI                   | 01:12.639\n" +
                "7. Fernando Alonso | MCLAREN RENAULT           | 01:12.657\n" +
                "8. Sergey Sirotkin | WILLIAMS MERCEDES         | 01:12.706\n" +
                "9. Charles Leclerc | SAUBER FERRARI            | 01:12.829\n" +
                "10. Sergio Perez | FORCE INDIA MERCEDES      | 01:12.848\n" +
                "11. Romain Grosjean | HAAS FERRARI              | 01:12.930\n" +
                "12. Pierre Gasly | SCUDERIA TORO ROSSO HONDA | 01:12.941\n" +
                "13. Carlos Sainz | RENAULT                   | 01:12.950\n" +
                "14. Esteban Ocon | FORCE INDIA MERCEDES      | 01:13.028\n" +
                "15. Nico Hulkenberg | RENAULT                   | 01:13.065\n" +
                "------------------------------------------------------------\n" +
                "16. Brendon Hartley | SCUDERIA TORO ROSSO HONDA | 01:13.179\n" +
                "17. Marcus Ericsson | SAUBER FERRARI            | 01:13.265\n" +
                "18. Lance Stroll | WILLIAMS MERCEDES         | 01:13.323\n" +
                "19. Kevin Magnussen | HAAS FERRARI              | 01:13.393\n";

        assertEquals(expectedString, actualString);
    }

    @Test
    void format_whenListIsOfOneRacer() {

        actualString = formatter.format(racers.stream().limit(1).collect(Collectors.toList()));
        expectedString =
            "1. Sebastian Vettel | FERRARI | 01:04.415\n";

        assertEquals(expectedString, actualString);
    }


    @Test
    void format_whenListIsOfFifteenRacers() {

        actualString = formatter.format(racers.stream().limit(15).collect(Collectors.toList()));
        expectedString =
            "1. Sebastian Vettel | FERRARI                   | 01:04.415\n" +
                "2. Daniel Ricciardo | RED BULL RACING TAG HEUER | 01:12.013\n" +
                "3. Valtteri Bottas | MERCEDES                  | 01:12.434\n" +
                "4. Lewis Hamilton | MERCEDES                  | 01:12.460\n" +
                "5. Stoffel Vandoorne | MCLAREN RENAULT           | 01:12.463\n" +
                "6. Kimi Raikkonen | FERRARI                   | 01:12.639\n" +
                "7. Fernando Alonso | MCLAREN RENAULT           | 01:12.657\n" +
                "8. Sergey Sirotkin | WILLIAMS MERCEDES         | 01:12.706\n" +
                "9. Charles Leclerc | SAUBER FERRARI            | 01:12.829\n" +
                "10. Sergio Perez | FORCE INDIA MERCEDES      | 01:12.848\n" +
                "11. Romain Grosjean | HAAS FERRARI              | 01:12.930\n" +
                "12. Pierre Gasly | SCUDERIA TORO ROSSO HONDA | 01:12.941\n" +
                "13. Carlos Sainz | RENAULT                   | 01:12.950\n" +
                "14. Esteban Ocon | FORCE INDIA MERCEDES      | 01:13.028\n" +
                "15. Nico Hulkenberg | RENAULT                   | 01:13.065\n";

        assertEquals(expectedString, actualString);
    }
}
