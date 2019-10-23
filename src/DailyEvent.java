import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DailyEvent extends AbstractEvent {
    private int recurrance;

    DailyEvent(String description, int recurrance, Date start, Date end){
        super(description, start, end);

        this.recurrance = recurrance;
    }

    public  Boolean hasMoreOccurences(){

    }

    public  Date nextOccurence(){

    }

    public  void init(){

    }
}
