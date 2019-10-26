import java.util.Date;


public abstract class AbstractEvent {

    //Variable declarations
    private String description;
    private Date start, end;

    //Class Constructor
    AbstractEvent(String description, Date start, Date end) {
        this.description = description;
        this.start = start;
        this.end = end;
    }

    //Getters and setters
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

    //Abstract Functions to be implemented in Sub-classes
    public abstract Boolean hasMoreOccurences();

    public abstract Date nextOccurence();

    public abstract void init();

}
