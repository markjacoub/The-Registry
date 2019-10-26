import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DailyEvent extends AbstractEvent {
    //Variable Declarations
    private int recurrence;
    private int calls;
    public static final long daysInMilliSeconds = 86400000;

    //Class Constructor
    DailyEvent(String description, Date start, Date end, int recurrence) {
        super(description, start, end); //Explicit call to Superclass constuctor
        //Subclass constructor
        this.recurrence = recurrence;
        this.calls = 0;
    }

    //Overrides hasMoreOccurences of parent class
    @Override
    public Boolean hasMoreOccurences() {
        return calls < recurrence; // return true if calls < recurrences (meaning daily event can call nextOccurence)
    }

    //Overrides nextOccurences of parent class
    @Override
    public Date nextOccurence() {
        if (hasMoreOccurences()) {
            calls++; //Increment calls count
            Date temp = getStart(); //get the start date of the event
            long time = temp.getTime(); //convert the date to integer time relative to epoch time (1/1/1970)
            time += daysInMilliSeconds * calls; //increment time relative to the call count
            temp.setTime(time); //set new time in temp object
            return temp;
        } else
            return null; //undefined handler in case no more occurences exist
    }

    //Resets call counter
    @Override
    public void init() {
        this.calls = 0;
    }


    public int getRecurrence() {
        return recurrence;
    }

    //Setters and getters

    public void setRecurrence(int recurrence) {
        this.recurrence = recurrence;
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }


    //Returns string representation of event
    @Override
    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        String format = "MMM dd, yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, new Locale("en", "EG"));

        String date = simpleDateFormat.format(this.getStart());
        str.append("Daily Event: {").append("Description= ").append(getDescription()).append(", startTime= ").append(date);
        date = simpleDateFormat.format(this.getEnd());
        str.append(", EndTime= ").append(date).append(", numberOdRecurrences= ").append(this.getRecurrence()).append("}");
        return str.toString();
    }
}
