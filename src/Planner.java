import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Planner {
    private int maxSize;
    private ArrayList<AbstractEvent> events = new ArrayList<AbstractEvent>();

    Planner(int maxSize) {
        this.maxSize = maxSize;
    }

    public int size() {
        return events.size();
    }

    public boolean addEvent(AbstractEvent event) {
        if (maxSize > events.size())
            return events.add(event);
        else
            return false;
    }

    public int getSize() {
        return events.size();
    }

    public AbstractEvent eventAt(int pos) {
        return events.get(pos);
    }

    public AbstractEvent remove(int pos) {
        return events.remove(pos);
    }

    void display(Date date) {
        for (AbstractEvent event : events) {
            if (event instanceof DailyEvent) {
                if (event.hasMoreOccurences() && event.getStart().getTime() <= date.getTime()) {
                    long endDate = ((DailyEvent) event).getRecurrence() * DailyEvent.daysInMilliSeconds + event.getStart().getTime();
                    if (endDate >= date.getTime())
                        System.out.println(event);

                }
            } else if (event instanceof WeeklyEvent) {
                if (event.hasMoreOccurences() && ((WeeklyEvent) event).getLimit().getTime() >= date.getTime()) {
                    System.out.println(event);

                }
            }


        }
    }

    void sort(Comparator<AbstractEvent> c) {
        events.sort(c);
    }

    @Override
    public String toString() {
        StringBuilder str;
        str = new StringBuilder("Planner: { \n");
        for (AbstractEvent event : events) {
            str.append(event.toString()).append("\n");
        }

        str.append("} \n");
        return str.toString();
    }
}