package generic_programming.exercise1;

import static javafx.scene.input.KeyCode.V;

public class PairPredicate<S,T> implements Predicate<Pair<S,T>>  {

    private Predicate<S> p1;
    private Predicate<T> p2;

    public PairPredicate(Predicate<S> p1, Predicate<T> p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean test(Pair<S, T> value) {
        if (p1.test(value.getFirst()) && p2.test(value.getSecond())){
            return true;
        }
        return false;
    }
}
