package generic_programming.exercise1;

public class PairFunction<S, T> implements Function<Pair<S, T>> {

	private Function<S> f1;
	private Function<T> f2;


	public PairFunction(Function<S> f1, Function<T> f2) {
        this.f1 = f1;
        this.f2 = f2;
	}


    /**
     * Apply Function1 to the First element of our pair
     * Apply Function2 to the Second element of our pair
     */
	@Override
	public Pair<S, T> apply(Pair<S, T> pair) {
        S value1 = f1.apply(pair.getFirst());
        T value2 = f2.apply(pair.getSecond());

		return new Pair<>(value1, value2);
	}
}
