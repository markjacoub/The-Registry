import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args)
            throws java.text.ParseException {
        if (args.length != 1) {
            System.err.println("Usage: java Test date");
            System.exit(-1);
        }
        //Intial Commit
        Planner p;
        Calendar cal;
        Date input, start, end, limit;
        DateFormat df;
        df = new SimpleDateFormat("MMM d, yyyy", Locale.EGYPT);
        input = df.parse(args[0]);
        p = new Planner(1000);
        limit = Utils.getTime(2019, Calendar.APRIL, 8);
        start = Utils.getTime(2019, Calendar.FEBRUARY, 21, 8, 30);
        end = Utils.getTime(2019, Calendar.FEBRUARY, 21, 22, 0);
        p.addEvent(new DailyEvent("Study Break", start, end, 5));
        start = Utils.getTime(2019, Calendar.JANUARY, 6, 8, 30);
        end = Utils.getTime(2019, Calendar.JANUARY, 6, 10, 0);
        p.addEvent(new WeeklyEvent("CSCE 4321 Section B", start, end, limistart = Utils.getTime(2019, Calendar.JANUARY, 11, 10, 0);
        end = Utils.getTime(2019, Calendar.JANUARY, 11, 11, 30);
        p.addEvent(new WeeklyEvent("CSCE 1521 Section B", start, end, limit));
        start = Utils.getTime(2019, Calendar.JANUARY, 6, 13, 0);
        end = Utils.getTime(2019, Calendar.JANUARY, 6, 14, 30);
        p.addEvent(new WeeklyEvent("CSCE 1521 Section A", start, end, limit));
        start = Utils.getTime(2019, Calendar.JANUARY, 10, 11, 30);
        end = Utils.getTime(2019, Calendar.JANUARY, 10, 13, 0);
        p.addEvent(new WeeklyEvent("CSCE 1521 Section A", start, end, limit));
        start = Utils.getTime(2019, Calendar.JANUARY, 11, 14, 30);
        end = Utils.getTime(2019, Calendar.JANUARY, 11, 17, 30);
        p.addEvent(new WeeklyEvent("CSCE 4321 Section A", start, end, limit));
        start = Utils.getTime(2019, Calendar.JANUARY, 6, 14, 30);
        end = Utils.getTime(2019, Calendar.JANUARY, 6, 16, 0);
        p.addEvent(new WeeklyEvent("Office Hours", start, end, limit));
        start = Utils.getTime(2019, Calendar.JANUARY, 11, 12, 30);
        end = Utils.getTime(2019, Calendar.JANUARY, 11, 14, 0);
        p.addEvent(new WeeklyEvent("Office Hours", start, end, limit));
        start = Utils.getTime(2019, Calendar.APRIL, 11, 9, 30);
        end = Utils.getTime(2019, Calendar.APRIL, 11, 17, 30);
        p.addEvent(new DailyEvent("Examination", start, end, 18));
        System.out.println("Events on this date: " + df.format(input));
        System.out.println();
        p.display(input);
        System.out.println();
        System.out.println("Content of the Planner:");
        System.out.println();
        System.out.println(p);
        System.out.println();
        System.out.println("Sorting the content of the Planner by first occurrence...");
        p.sort(new FirstOccComparator());
        System.out.println();
        System.out.println("Content of the Planner:");
        System.out.println();
        System.out.println(p);
        System.out.println();
        System.out.println("Sorting the content of the Planner by last occurrence...");
        p.sort(new LastOccComparator());
        System.out.println();
        System.out.println("Content of the Planner:");
        System.out.println();
        System.out.println(p);
        System.out.println();
        System.out.println("Sorting the content of the Planner by description...");
        p.sort(new DescriptionComparator());
        System.out.println();
        System.out.println("Content of the Planner:");
        System.out.println();
        System.out.println(p);
    }
}