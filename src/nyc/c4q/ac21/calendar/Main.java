package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("date? ");
        String dateString = scanner.nextLine();
        Calendar date = DateTools.parseDate(dateString);
        if (date == null)
            return;


        System.out.println("date:              " + DateTools.formatDate(date));
        System.out.println();


        // 1. Show the day of the week.
        HashMap<Integer, String> dayOfWeekNames = DateTools.getDayOfWeekNames();
        System.out.println("day of week:       " + dayOfWeekNames.get(date.get(date.DAY_OF_WEEK)));

        // 2. Show whether this is a work day.
        HashMap<Integer, Boolean> workDays = WorkDays.getWorkDays();
        System.out.println("work day:          " + workDays.get(date.get(date.DAY_OF_WEEK)));

        // 3. Show whether this is a national holiday, and if so, which.
        HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
        System.out.println("national holiday:  " + holidays.get(date));

        // 4. Show whether this date is in DST.
        boolean isDST = DST.isDST(date);
        System.out.println("is DST:            " + isDST);

        // 5. Show the zodiac sign.
        String zodiacSign = Zodiac.getZodiacSign(date);
        System.out.println("Zodiac sign:       " + zodiacSign);
        System.out.println();

                // 6. Print out the monthly calendar.
                CalendarPrinter.printMonthCalendar(date);

        //System.out.println(date.DAY_OF_WEEK_IN_MONTH);

    }
}
