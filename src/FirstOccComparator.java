import java.util.Comparator;

public class FirstOccComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second) {
        return first.getStart().compareTo(second.getStart()); //Return integer value denoting difference between first and second
    }

}
