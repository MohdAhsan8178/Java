// Question 26: Using java.util Package (Date and Calendar Example): Write a program that uses the Date and Calendar classes to display the current date and time.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Q26_JavaUtilDateAndCalendar {
    public static void main(String[] args) {
        System.out.println("--- Section 6: Exploring Java Packages ---");
        System.out.println("--- Q26: Date and Calendar from java.util Package ---\n");

        // 1. Using java.util.Date
        Date currentDate = new Date();
        System.out.println("1. Using java.util.Date:");
        System.out.println("   Default Date.toString() : " + currentDate);
        System.out.println("   Raw epoch milliseconds  : " + currentDate.getTime());

        // Formatting Date with SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy 'at' hh:mm:ss a z");
        System.out.println("   Formatted Date/Time     : " + sdf.format(currentDate));

        // 2. Using java.util.Calendar
        Calendar calendar = Calendar.getInstance();
        System.out.println("\n2. Using java.util.Calendar:");
        System.out.println("   Time Zone : " + calendar.getTimeZone().getDisplayName());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Months are 0-indexed
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour24 = calendar.get(Calendar.HOUR_OF_DAY);
        int hour12 = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String amPm = (calendar.get(Calendar.AM_PM) == Calendar.AM) ? "AM" : "PM";

        System.out.println("   Extracted Calendar Fields:");
        System.out.println("   - Year         : " + year);
        System.out.println("   - Month        : " + month);
        System.out.println("   - Day          : " + day);
        System.out.println("   - Time (24-hr) : " + String.format("%02d:%02d:%02d", hour24, minute, second));
        System.out.println("   - Time (12-hr) : " + String.format("%02d:%02d:%02d %s", (hour12 == 0 ? 12 : hour12), minute, second, amPm));

        // Adding 7 days using Calendar
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println("\n3. Calendar Arithmetic (Date after 7 days):");
        System.out.println("   Next Week Date : " + sdf.format(calendar.getTime()));

        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
