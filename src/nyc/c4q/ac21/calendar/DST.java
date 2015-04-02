package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Daylight Savings Time (DST) computations.
 */
public class DST {

    /**
     * Populates hash maps with the start and end time for DST in each year.
     * @param startDates
     *   A hash map of the start date of DST in each year.
     * @param endDates
     *   A hash map of the end date of DST in each year.
     */
    public static void getDSTDates(HashMap<Integer, Calendar> startDates, HashMap<Integer, Calendar> endDates) {
        ArrayList<String> lines = FileTools.readLinesFromFile("dst.csv");

        // Each line in the file is of the form "start,end", where both dates
        // are in the same year.  This represents the dates DST starts and
        // ends in this year.
        //
        // Use DateTools.parseDate.
        for (int i = 0; i < lines.size(); i++) {
            String startDate =  lines.get(i).substring(0,10);   //split string start date and ens date
            String endDate =  lines.get(i).substring(11,21);

            startDates.put(Integer.parseInt(startDate.substring(0,4)), DateTools.parseDate(startDate)); //split start date into (year, date)
            endDates.put(Integer.parseInt(endDate.substring(0,4)), DateTools.parseDate(endDate));   ////split end date into (year, date)
        }

    }

    /**
     * Returns true if 'date' is during Daylight Savings Time.
     * @param date
     *   The date to check.
     * @return
     *   True if DST is in effect on this date.
     */
    public static boolean isDST(Calendar date) {
        // Creates hash maps to contain the start and end dates for DST in each year.
        HashMap<Integer, Calendar> dstStartDates = new HashMap<Integer, Calendar>();
        HashMap<Integer, Calendar> dstEndDates = new HashMap<Integer, Calendar>();
        // Populates them.
        DST.getDSTDates(dstStartDates, dstEndDates);

        //int yearAsInt = Integer.parseInt(DateTools.formatDate(date).substring(0,5));  //extracts year out of date
        int yearsInt = date.get(date.YEAR);

        Calendar currentStartDate = dstStartDates.get(yearsInt);
        Calendar currentEndDate = dstEndDates.get(yearsInt);

        return  !(date.before(currentStartDate) || date.after(currentEndDate));


//        following statements is the same ass statement above^^^^^
//        if (date.before(currentStartDate) || date.after(currentEndDate)) {
//            return false;
//        }
//        else
//        return true;



    }

}


