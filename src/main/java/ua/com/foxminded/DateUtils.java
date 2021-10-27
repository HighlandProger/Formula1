package ua.com.foxminded;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String TIME_PATTERN = "mm:ss.SSS";
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";

    private DateUtils() {
    }

    public static long getTimeDifference(String startTimeString, String endTimeString) {

        Date startDate = getDateFromString(startTimeString);
        Date endDate = getDateFromString(endTimeString);

        return endDate.getTime() - startDate.getTime();
    }

    public static String formatTime(long milliseconds) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat(TIME_PATTERN);
        return dateFormatter.format(milliseconds);
    }

    public static Date getDateFromString(String dateString) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_TIME_PATTERN);
        Date date;

        try {
            date = dateFormatter.parse(dateString);
        } catch (ParseException e) {
            throw new DateUtilsException("Cannot read " + dateString + ". Check date string");
        }

        return date;
    }

}
