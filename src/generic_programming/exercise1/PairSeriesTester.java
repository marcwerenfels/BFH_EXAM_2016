package generic_programming.exercise1;

public class PairSeriesTester {

	public static void main(String[] args) {

		Series<Integer> s1 = new Series<Integer>(0, x -> x + 2, x -> x <= 10);
		Series<String> s2 = new Series<String>("", s -> s + "*", s -> s.length() <= 10);

		PairSeries<Integer, String> s12 = new PairSeries<>(s1, s2);
		System.out.println(s12.toList());
	}
}
