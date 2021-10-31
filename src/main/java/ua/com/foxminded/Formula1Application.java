package ua.com.foxminded;

import ua.com.foxminded.domain.Racer;
import ua.com.foxminded.formatter.DataReader;
import ua.com.foxminded.formatter.QualificationTableFormatter;

import java.util.List;

public class Formula1Application {
    public static void main(String[] args) {

        DataReader dataReader = new DataReader();

        List<Racer> racers = dataReader.getRacers();

        QualificationTableFormatter qualificationTableFormatter = new QualificationTableFormatter();
        System.out.println(qualificationTableFormatter.format(racers));

    }

}
