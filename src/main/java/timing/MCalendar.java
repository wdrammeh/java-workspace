package timing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MCalendar {

    public static void main(String[] args) throws ParseException {
//        create a date instance based on the current time
        final Date date = new Date();
        System.out.println(date);

//        create using the calendar instance
        final Calendar cal = Calendar.getInstance();
        Date date1 = cal.getTime();
        System.out.println(date1);

//        create from an existing string? parse to a a date-formatter
        final String someDate = "01-01-1999";
        final DateFormat format = new SimpleDateFormat("d-M-y");
        final Date date2 = format.parse(someDate);
        System.out.println(date2);
        System.out.println(format.format(date2));

//        play with the calendar
        final String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        final String dayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        final String day = Integer.toString(cal.get(Calendar.DATE));
        final String year = Integer.toString(cal.get(Calendar.YEAR));
        final String time = SimpleDateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());
        System.out.println(monthName+" "+day+", "+year+" ["+dayName+"] "+time);

//        specific date-formats
        final DateFormat tf = SimpleDateFormat.getTimeInstance(DateFormat.SHORT);
        final DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.DEFAULT, Locale.US);
        System.out.println(tf.format(new Date()));
        System.out.println(df.format(new Date()));
    }

}
