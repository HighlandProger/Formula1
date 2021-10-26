package ua.com.foxminded;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat millisecondsToDateFormatter = new SimpleDateFormat("mm:ss.SSS");
    private static final SimpleDateFormat dateToStringFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    private DateUtils() {
    }

    public static long getTimeDifference(String startTimeString, String endTimeString) {

        Date startDate = getDateFromString(startTimeString);
        Date endDate = getDateFromString(endTimeString);

        return getDateDifference(startDate, endDate);
    }

    public static String getTimeFromMilliseconds(long milliseconds) {
        return millisecondsToDateFormatter.format(milliseconds);
    }

    private static Date getDateFromString(String logString) {

        StringBuilder builder = new StringBuilder(logString);
        String dateString = builder.substring(3);
        Date date = new Date();

        try {
            date = dateToStringFormatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private static long getDateDifference(Date startDate, Date endDate) {
        return endDate.getTime() - startDate.getTime();
    }

}
