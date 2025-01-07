package dps3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
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

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        final BigDecimal bigDecimal = BigDecimal.valueOf(value);
        return bigDecimal.setScale(places, RoundingMode.HALF_UP).doubleValue();
    }

    public static String numberFormat(Number number) {
        return NumberFormat.getNumberInstance().format(number);
    }

}
