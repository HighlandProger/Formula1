package ua.com.foxminded;

import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.formatter.DataReader;
import ua.com.foxminded.formatter.QualificationTableFormatter;

import java.util.List;

public class Formula1Application {
    public static void main(String[] args) {

        DataReader dataReader = new DataReader();

        String startLog = "start.log";
        String endLog = "end.log";
        String abbreviations = "abbreviations.txt";

        List<Racer> racers = dataReader.getRacers(startLog, endLog, abbreviations);

        QualificationTableFormatter qualificationTableFormatter = new QualificationTableFormatter();
        System.out.println(qualificationTableFormatter.format(racers));

    }

}
