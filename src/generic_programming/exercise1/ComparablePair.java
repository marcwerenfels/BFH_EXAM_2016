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

    public static <S extends Comparable<S>, T extends Comparable<T>> Pair<S,T> getMin (ComparablePair<S,T> pair1, ComparablePair<S,T> pair2){
        int c = pair1.compareTo(pair2);
        if (c > 0){
            return pair2;
        } else if (c < 1){
            return pair1;
        } else {
            return pair1;
        }
    }

    public static <S extends Comparable<S>, T extends Comparable<T>> Pair<S,T> getMax (ComparablePair<S,T> pair1, ComparablePair<S,T> pair2){
        int c = pair1.compareTo(pair2);
        if (c > 0){
            return pair1;
        } else if (c < 1){
            return pair2;
        } else {
            return pair1;
        }
    }
}
