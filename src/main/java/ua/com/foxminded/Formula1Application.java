package ua.com.foxminded;

import java.util.List;

public class Formula1Application {
    public static void main(String[] args) {

        DataReader dataReader = new DataReader();
        StringFormatter stringFormatter = new StringFormatter();

        List<Racer> racers = dataReader.getRacersList();

        System.out.println(stringFormatter.getFormattedString(racers));

    }

}
