package ua.com.foxminded;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    private final SimpleDateFormat millisecondsToDateFormatter = new SimpleDateFormat("mm:ss.SSS");
    private final SimpleDateFormat dateToStringFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    public String getTimeDifference(String startTimeString, String endTimeString) {

        Date startDate = getDateFromString(startTimeString);
        Date endDate = getDateFromString(endTimeString);
        long timeDifference = getDateDifference(startDate, endDate);

        return getTimeFromMilliseconds(timeDifference);
    }

    private Date getDateFromString(String logString) {

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

    private long getDateDifference(Date startDate, Date endDate) {
        return endDate.getTime() - startDate.getTime();
    }

    private String getTimeFromMilliseconds(long milliseconds) {
        return millisecondsToDateFormatter.format(milliseconds);
    }

}