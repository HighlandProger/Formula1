package ua.com.foxminded.util;

import ua.com.foxminded.exception.DateParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String TIME_PATTERN = "mm:ss.SSS";
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";

    private DateUtils() {
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
            throw new DateParseException("Cannot read " + dateString + ". Check date string");
        }

        return date;
    }

}
