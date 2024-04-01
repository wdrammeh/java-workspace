package dps;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    
    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, (month - 1), day, 0, 0, 0);
        return cal.getTime();
    }

    public static Date getDate() {
        Calendar cal = Calendar.getInstance();
        return getDate(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 1), cal.get(Calendar.DAY_OF_MONTH));
    }

}
