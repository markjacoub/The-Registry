import java.util.Date;


public abstract class AbstractEvent {

    private String description;
    private Date start ,end;

    AbstractEvent(String description, Date start, Date end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    Date getStart() {
        return start;
    }

    Date getEnd() {
        return end;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setStart(Date start) {
        this.start = start;
    }

    void setEnd(Date end) {
        this.end = end;
    }

    public abstract Boolean hasMoreOccurences();

    public abstract Date nextOccurence();

    public abstract void init();
}
