package generic_programming.exercise3;

import generic_programming.exercise1.Function;
import generic_programming.exercise1.Predicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Series<V> implements Iterator<V> {

    private V initialValue;
    private V currentValue;
    private Function<V> update;
    private Predicate<V> condition;

    public Series(V initialValue, Function<V> update, Predicate<V> condition) {
        this.initialValue = initialValue;
        this.currentValue = initialValue;
        this.update = update;
        this.condition = condition;
    }

    public Series(V initialValue, Function<V> update, V endValue) {
        this(initialValue, update, value -> !value.equals(update.apply(endValue)));
    }

    private Series() {

    }

    public V getInitialValue() {
        return this.initialValue;
    }

    public Function<V> getUpdate() {
        return this.update;
    }

    public Predicate<V> getCondition() {
        return this.condition;
    }

    public boolean hasNext() {
        return this.condition.test(this.currentValue);
    }

    public V next() {
        if (!this.hasNext()) {
            throw new IllegalStateException();
        }
        V next = this.currentValue;
        this.currentValue = this.update.apply(this.currentValue);
        return next;
    }

    public void reset() {
        this.currentValue = this.initialValue;
    }

    public List<V> toList() {
        List<V> list = new ArrayList<>();
        V currentValue = this.currentValue;
        this.currentValue = this.initialValue;
        while (this.hasNext()) {
            list.add(this.next());
        }
        this.currentValue = currentValue;
        return list;
    }

    public Series<V> limit(long maxLength) {
        Series<V> parent = this;
        return new Series<V>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                if (parent.hasNext() && counter < maxLength) {
                    return true;
                }
                return false;

            }

            @Override
            public V next() {
                counter++;
                return parent.next();
            }

            @Override
            public void reset() {
                counter = 0;
                parent.reset();
            }

        };
    }

    public Series<V> map(Function<V> function) {
        Series<V> parent = this;
        return new Series<V>() {


            @Override
            public boolean hasNext() {
                return parent.hasNext();
            }

            @Override
            public V next() {
                V next = parent.next();
                return function.apply(next);
            }

            @Override
            public void reset() {
                parent.reset();
            }


        };
    }

    public static void main(String[] args) {

        Series<Integer> s1 = new Series<Integer>(0, x -> x + 1, x -> x <= 10);
        Series<Integer> s2 = s1.map(x -> x*x).limit(5);

        System.out.println(s2.toList());
        // prints [0, 1, 4, 9, 16]
    }

}
