import java.util.Comparator;

public class DescriptionComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second) {
        return first.getDescription().compareTo(second.getDescription()); //returns int corresponding to lexicographic order of 2 strings
    }
}