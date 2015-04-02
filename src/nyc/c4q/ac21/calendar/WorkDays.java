package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class WorkDays {

    /**
     * Builds a map from day of week to whether this is a work day.
     * @return
     *   A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY', indicating whether each is a work day.
     */
    public static HashMap<Integer, Boolean> getWorkDays() {

        HashMap<Integer, Boolean> workDays = new HashMap<Integer, Boolean>();

        Calendar calendar = Calendar.getInstance();

        workDays.put(calendar.MONDAY, true);
        workDays.put(calendar.TUESDAY, true);
        workDays.put(calendar.WEDNESDAY, true);
        workDays.put(calendar.THURSDAY, true);
        workDays.put(calendar.FRIDAY, true);
        workDays.put(calendar.SATURDAY, false);
        workDays.put(calendar.SUNDAY, false);

        return workDays;
    }

}
