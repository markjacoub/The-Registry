import java.util.Comparator;

public class FirstOccComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second) {
        return (int) (first.getStart().getTime() - second.getStart().getTime()); //Return integer value denoting difference between first and second
    }

}
