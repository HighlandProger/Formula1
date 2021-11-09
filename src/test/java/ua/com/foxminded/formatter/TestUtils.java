package ua.com.foxminded.formatter;

import ua.com.foxminded.domain.Racer;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    private TestUtils() {
    }

    public static List<Racer> getDefaultRacers() {

        List<Racer> racers = new ArrayList<>();
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

        return racers;
    }

    public static List<Racer> getRacersWithManyTimePoints() {

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

        return racers;
    }

    public static List<Racer> getDefaultRacersWithLessTimePoints() {

        List<Racer> racers = new ArrayList<>();
        racers.add(new Racer("DRR", "Daniel Ricciardo", "RED BULL RACING TAG HEUER", 72013));
        racers.add(new Racer("VBM", "Valtteri Bottas", "MERCEDES", 72434));
        racers.add(new Racer("LHM", "Lewis Hamilton", "MERCEDES", 72460));
        racers.add(new Racer("KRF", "Kimi Raikkonen", "FERRARI", 72639));
        racers.add(new Racer("SSW", "Sergey Sirotkin", "WILLIAMS MERCEDES", 72706));
        racers.add(new Racer("CLS", "Charles Leclerc", "SAUBER FERRARI", 72829));
        racers.add(new Racer("SPF", "Sergio Perez", "FORCE INDIA MERCEDES", 72848));
        racers.add(new Racer("RGH", "Romain Grosjean", "HAAS FERRARI", 72930));
        racers.add(new Racer("PGS", "Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", 72941));
        racers.add(new Racer("EOF", "Esteban Ocon", "FORCE INDIA MERCEDES", 73028));
        racers.add(new Racer("BHS", "Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", 73179));
        racers.add(new Racer("MES", "Marcus Ericsson", "SAUBER FERRARI", 73265));
        racers.add(new Racer("KMH", "Kevin Magnussen", "HAAS FERRARI", 73393));
        racers.add(new Racer("SVF", "Sebastian Vettel", "FERRARI", 0));
        racers.add(new Racer("FAM", "Fernando Alonso", "MCLAREN RENAULT", 0));
        racers.add(new Racer("CSR", "Carlos Sainz", "RENAULT", 0));
        racers.add(new Racer("NHR", "Nico Hulkenberg", "RENAULT", 0));
        racers.add(new Racer("SVM", "Stoffel Vandoorne", "MCLAREN RENAULT", 0));
        racers.add(new Racer("LSW", "Lance Stroll", "WILLIAMS MERCEDES", 0));

        return racers;
    }

    public static List<Racer> getOneRacer() {

        List<Racer> racers = new ArrayList<>();
        racers.add(new Racer("SVF", "Sebastian Vettel", "FERRARI", 64415));

        return racers;
    }

    public static List<Racer> getFifteenRacers() {

        List<Racer> racers = new ArrayList<>();
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

        return racers;
    }

}
