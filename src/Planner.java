import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


public class Planner {
    private int maxSize; //Keeps max size of planner
    private ArrayList<AbstractEvent> events; // Stores events
    private ArrayList<Notification> observers; //stores observers to notify when events are added

    //Class Constructor
    Planner(int maxSize) {
        observers = new ArrayList<Notification>();
        events = new ArrayList<AbstractEvent>(maxSize);
        this.maxSize = maxSize;
    }

    //Adds event to planner and updates all observers
    public boolean addEvent(AbstractEvent event) {
        if (maxSize > events.size()) {
            boolean flag = events.add(event);
            notifySubscribers();
            return flag;
        } else
            return false;
    }
    //Returns number of events stored
    public int getSize() {
        return events.size();
    }
    //Gets index of event in planner
    public AbstractEvent eventAt(int pos) {
        return events.get(pos);
    }

    //Removes event at specified index
    public AbstractEvent remove(int pos) {
        return events.remove(pos);
    }

    //Displays contents of the planner with upcoming occurences
    void display(Date date) {
        for (AbstractEvent event : events) {
            if (event instanceof DailyEvent) {
                if (event.hasMoreOccurences() && event.getStart().getTime() <= date.getTime()) {
                    long endDate = ((DailyEvent) event).getRecurrence() * DailyEvent.daysInMilliSeconds + event.getStart().getTime();
                    if (endDate >= date.getTime())
                        System.out.println(event);
                }
            } else if (event instanceof WeeklyEvent) {
                if (event.hasMoreOccurences() && ((WeeklyEvent) event).getStart().getTime() <= date.getTime()) {
                    long dateInDays = date.getTime() / DailyEvent.daysInMilliSeconds + 1;
                    long endDate = event.getStart().getTime();
                    while (((WeeklyEvent) event).getLimit().getTime() > endDate + DailyEvent.daysInMilliSeconds * 7) {
                        long eventInDays = endDate / DailyEvent.daysInMilliSeconds;
                        if (eventInDays == dateInDays)
                            System.out.println(event);

                        endDate += DailyEvent.daysInMilliSeconds * 7;
                    }
                }
            }


        }
    }

    //Sorts array based on passed comparator
    void sort(Comparator<AbstractEvent> c) {
        events.sort(c);
    }


    //Returns string representation of planner
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

    //Adds subcriber to observers list
    public void Subscribe(Notification observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer subscribed successfully.");
        } else
            System.out.println("Observer already subscribed");
    }

    //Removes subscriber from observers list
    public void Unsubscribe(Notification observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            System.out.println("Observer unsubscribed successfully.");
        } else
            System.out.println("Error, observer not subscribed.");
    }

    //Notifies subscribers of current size
    public void notifySubscribers() {
        for (Notification observer : observers) {
            observer.sendNotification(this);
        }
    }
}