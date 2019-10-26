import java.util.Calendar;
import java.util.Comparator;

public class LastOccComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second) {
        long firstEnd = 0, secondEnd = 0;

        if (first instanceof DailyEvent)
            firstEnd = first.getEnd().getTime() + (((DailyEvent) first).getRecurrence() * DailyEvent.daysInMilliSeconds);
        else if (first instanceof WeeklyEvent) {
            long limit = ((WeeklyEvent) first).getLimit().getTime();
            firstEnd = first.getEnd().getTime();
            while (firstEnd < limit) {
                firstEnd += DailyEvent.daysInMilliSeconds;
            }
        }


        if (second instanceof DailyEvent)
            secondEnd = second.getEnd().getTime() + (((DailyEvent) second).getRecurrence() * DailyEvent.daysInMilliSeconds);
        else if (second instanceof WeeklyEvent) {
            long limit = ((WeeklyEvent) second).getLimit().getTime();
            secondEnd = second.getEnd().getTime();
            while (secondEnd + DailyEvent.daysInMilliSeconds < limit) {
                secondEnd += DailyEvent.daysInMilliSeconds;
            }
        }

        System.out.print(firstEnd);
        System.out.println("+" + secondEnd);
        return Long.compare(firstEnd, secondEnd);
    }
}