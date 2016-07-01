package generic_programming.exercise1;

public class ComparablePair<S extends Comparable<S>, T extends Comparable<T>> extends Pair<S, T> implements Comparable<Pair<S, T>> {

    public ComparablePair(S first, T second) {
        super(first, second);
    }

    @Override
    public int compareTo(Pair<S, T> pair) {
        int c = this.getFirst().compareTo(pair.getFirst());
        if (c != 0) {
            return c;
        } else {
            return this.getSecond().compareTo(pair.getSecond());
        }
    }
}
