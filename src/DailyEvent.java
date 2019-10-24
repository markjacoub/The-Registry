import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DailyEvent extends AbstractEvent {
    private int recurrence;
    private int calls;
    private final long daysInMilliSeconds = 86400000;

    DailyEvent(String description, int recurrence, Date start, Date end) {
        super(description, start, end);
        this.recurrence = recurrence;
        this.calls = 0;
    }

    @Override
    public Boolean hasMoreOccurences() {
        return calls < recurrence;
    }

    @Override
    public Date nextOccurence() {
        if (hasMoreOccurences()) {
            calls++;
            Date temp = getStart();
            long time = temp.getTime();
            time += daysInMilliSeconds * calls;
            temp.setTime(time);
            return temp;
        } else
            return null;
    }

    @Override
    public void init() {
        this.calls = 0;
    }

    public int getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }


    @Override
    public String toString() {
        return "Description=" + getDescription() + ", startTime=" + getStart().toString() + ", endTime=" + getEnd().toString() +
                ", numberOfOccurences= " + getRecurrence();
    }
}
