package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarPrinter
{

    /**
     * Prints a calendar for a month.
     *
     * Prints the calendar in the traditional format with one week per line.
     * Each week starts on Sunday and shows the days of month for days in
     * that week.  The current date is marked with an asterisk.
     *
     * For example, for 2015-04-03, prints this:
     *
     *     April 2015
     *                  1   2   3*  4
     *      5   6   7   8   9  10  11
     *     12  13  14  15  16  17  18
     *     19  20  21  22  23  24  25
     *     26  27  28  29  30
     *
     * @param date
     *   The date containing the month to print.
     */
    public static void printMonthCalendar(Calendar date) {
        // FIXME: Write this.
        // Use these methods to help you:
        //   DateTools.getMonthNames()
        //   DateTools.getNextDay() to loop through days in the month.

        int dateYear = date.get(date.YEAR);             // format input year to int
        int dateMonth = date.get(date.MONTH);           // format input month to int
        int dateDay = date.get(date.DAY_OF_MONTH);      // format input day to int

        Calendar firstOfMonth = Calendar.getInstance();
        firstOfMonth.set(dateYear, dateMonth, 1);

        int startDay = firstOfMonth.get(firstOfMonth.DAY_OF_WEEK);      // find the day of the week that the first falls on
        int daysInMonth = date.getActualMaximum(date.DAY_OF_MONTH);     // find the number of days in given month
        String monthName = DateTools.getMonthNames().get(dateMonth);    // get the name using DateTools
        String padding = "";

        System.out.println(monthName + " " + dateYear);                 // prints month and year
        for (int i = 1; i < startDay; i++) {
            padding += "    ";                                          // builds up padding for first week
        }
        System.out.print(padding);

        for (int i = 1; i <= daysInMonth; i++) {
            if (i < 10)
                System.out.print(" ");                                  // adds an extra space in front of single digit dates
            if (i == dateDay)
                System.out.print(i + "* ");                             // marks current day
            else
                System.out.print(i + "  ");                             // prints day number
            if ((i - 1 + startDay) % 7 == 0)
                System.out.print("\n");                                 // new line for each week
        }
    }
}
