import java.util.Calendar;
import java.util.Comparator;

public class LastOccComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second) {
        long firstEnd = 0, secondEnd = 0;

        //Gets last occurence time based on whether the event is of type DailyEvent or Weekly Event
        if (first instanceof DailyEvent)
            firstEnd = first.getStart().getTime() + (((DailyEvent) first).getRecurrence() * DailyEvent.daysInMilliSeconds);
        else if (first instanceof WeeklyEvent) {
            long limit = ((WeeklyEvent) first).getLimit().getTime();
            firstEnd = first.getStart().getTime();
            while (firstEnd + DailyEvent.daysInMilliSeconds * 7 < limit) {
                firstEnd += DailyEvent.daysInMilliSeconds * 7;
            }
        }

        if (second instanceof DailyEvent)
            secondEnd = second.getStart().getTime() + (((DailyEvent) second).getRecurrence() * DailyEvent.daysInMilliSeconds);
        else if (second instanceof WeeklyEvent) {
            long limit = ((WeeklyEvent) second).getLimit().getTime();
            secondEnd = second.getStart().getTime();
            while (secondEnd + DailyEvent.daysInMilliSeconds * 7 < limit) {
                secondEnd += DailyEvent.daysInMilliSeconds * 7;
            }
        }

        return Long.compare(firstEnd, secondEnd);
    }
}