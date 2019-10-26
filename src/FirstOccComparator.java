import java.util.Comparator;

public class FirstOccComparator implements Comparator<AbstractEvent> {

    //Overrides compare in Comparator<T> class
    @Override
    public int compare(AbstractEvent first, AbstractEvent second) {
//        System.out.println(first.getStart().getTime() + " \n minus \n");
//        System.out.println(second.getStart().getTime() + "\n eqials\n");
//        System.out.println(first.getStart().getTime() - second.getStart().getTime());

        return first.getStart().compareTo(second.getStart()); //Return integer value denoting difference between first and second
    }

}
