import java.util.Comparator;

public class LastOccComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second){
        return (int) (second.getStart().getTime() - first.getStart().getTime()); //Return integer value denoting difference between first and second
    }
}