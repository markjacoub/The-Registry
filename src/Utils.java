import java.util.Date;
import java.util.Calendar;

public class Utils {

    //Returns Date object with day, month and year
    public static Date getTime(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();
    }
    //Returns Date object with day, month, year, hours and minutes
    public static Date getTime(int year, int month, int day, int hour, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minute);
        return cal.getTime();
    }

}
