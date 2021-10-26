package ua.com.foxminded;

import java.util.List;

public class Formula1Application {
    public static void main(String[] args) {

        DataReader dataReader = new DataReader();

        List<Racer> racers = dataReader.getRacersList();

        QualificationTableFormatter qualificationTableFormatter = new QualificationTableFormatter();
        System.out.println(qualificationTableFormatter.format(racers));

    }

}
