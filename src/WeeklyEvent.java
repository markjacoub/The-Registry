import java.util.Calendar;
import java.util.Date;

public class WeeklyEvent extends AbstractEvent{

    private Date limit;
    private int calls; //Number of times nextOccurence method hav been called

    //Class constuctor
    WeeklyEvent(String description, Date start, Date end,Date limit) {
        super(description, start, end);
        this.limit = limit;
        this.calls = 0;
    }

    //TODO:Testing
    @Override
    public Boolean hasMoreOccurences() {
        Calendar cal =Calendar.getInstance();
        cal.setTime(getStart());
        cal.add(Calendar.DATE,calls*7);

        if (limit.compareTo(cal.getTime()) > 0 )
            return true;
        else
            return false ;
    }

    @Override
    public Date nextOccurence() {
        /*THe approach of using 'Date' & 'Calendar' instead of 'LocalDate' library is outdated,
        Since JV8: https://stackoverflow.com/questions/23307324/how-do-i-add-2-weeks-to-a-date-in-java
        */
        Date start = getStart();//Get the start date
        Calendar cal =Calendar.getInstance();//Calendar instance
        cal.setTime(start); //set cal = start

        if(hasMoreOccurences()) {
           if(calls == 0){ //first call return start
               calls++; //increment for the next call
               return start;
           }
            cal.add(Calendar.DATE,calls*7);//increment cal by weeks
            calls++;//increment the number calls
            return cal.getTime();
        } else
            return null;
    }

    //Reset the call counter
    @Override
    public void init() { this.calls = 0;}

    //Setters and getters
    public Date getLimit() { return limit; }

    public void setLimit(Date limit) { this.limit =limit; }

    public int getCalls() { return calls; }

    public void setCalls(int calls) { this.calls = calls; }

    @Override
    public String toString() {
        return ("Description=" + getDescription() + ", startTime=" + getStart().toString() + ", endTime=" + getEnd().toString() +
                ", limitTime= " + getLimit().toString());
    }
}

