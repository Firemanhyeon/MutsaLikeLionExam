package ch11.Collection.exam3;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.getLike() , o2.getLike());
    }
}
class ReleaseYearComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o1.getYear() , o2.getYear());
    }
}
