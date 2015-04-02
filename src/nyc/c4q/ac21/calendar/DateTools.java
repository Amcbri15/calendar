package nyc.c4q.ac21.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class DateTools {
    /**
     * Formats a 'Calendar' object as a date.
     * @param cal
     *   The object to format.
     * @return
     *   The date in "YYYY-MM-DD" format.
     */
    public static String formatDate(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(cal.getTime());
    }

    /**
     * Parses a date in "YYYY-MM-DD" format.
     * @param date
     *   The date in "YYYY-MM-DD" format.
     * @return
     *   The date it represents, or null if the date is incorrectly formatted.
     */
    public static Calendar parseDate(String date) {
        if (date.length() == 10 && date.charAt(4) == '-' && date.charAt(7) == '-') {
            try {
                int year = Integer.valueOf(date.substring(0, 4));
                int month = Integer.valueOf(date.substring(5, 7));
                int dayOfMonth = Integer.valueOf(date.substring(8, 10));
                if (year > 0 && year <= 9999
                        && month >= 1 && month <= 12
                        && dayOfMonth >= 1 && dayOfMonth <= 31) {
                    // Allocate directly instead of using Calendar.getInstance() so that we don't
                    // set the time fields and leave them initialized to zero.
                    return new GregorianCalendar(year, month - 1, dayOfMonth);
                }
            } catch (NumberFormatException exception) {
                // Fall through.
            }
        }
        // Didn't work.
        return null;
    }

    /**
     * Returns the following day.
     */
    public static Calendar getNextDay(Calendar cal) {
        // 'Calendar' is mutable, but we don't want to change it.  Instead, create a copy and change that.
        cal = (Calendar) cal.clone();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal;
    }

    /**
     * Builds and returns a map from integers representing days of the week to the names of the days of the week.
     * @return
     *   A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY' with corresponding day names as values.
     */
    public static HashMap<Integer, String> getDayOfWeekNames() {

        HashMap<Integer, String> names = new HashMap<Integer, String>();

        Calendar calendar = Calendar.getInstance();

        // Sets the keys in this HashMap to integers that represent the days of the week using the Calendar method
        names.put(calendar.MONDAY, "Monday");
        names.put(calendar.TUESDAY, "Tuesday");
        names.put(calendar.WEDNESDAY, "Wednesday");
        names.put(calendar.THURSDAY, "Thursday");
        names.put(calendar.FRIDAY, "Friday");
        names.put(calendar.SUNDAY, "Sunday");
        names.put(calendar.SATURDAY, "Saturday");

        return names;
    }

    public static HashMap<Integer, String> getMonthNames() {

        HashMap<Integer, String> names = new HashMap<Integer, String>();

        Calendar calendar = Calendar.getInstance();

        // Sets the keys in this HashMap to integers representing the months of the year using the Calendar method
        names.put(calendar.JANUARY, "January");
        names.put(calendar.FEBRUARY, "February");
        names.put(calendar.MARCH, "March");
        names.put(calendar.APRIL, "April");
        names.put(calendar.MAY, "May");
        names.put(calendar.JUNE, "June");
        names.put(calendar.JULY, "July");
        names.put(calendar.AUGUST, "August");
        names.put(calendar.SEPTEMBER, "September");
        names.put(calendar.OCTOBER, "October");
        names.put(calendar.NOVEMBER, "November");
        names.put(calendar.DECEMBER, "December");

        return names;
    }

}
