package generic_programming.exercise1;

public class SeriesTester {

	public static void main(String[] args) {

		Series<Integer> s1 = new Series<>(0, x -> x + 1, x -> x <= 10);
		Series<Integer> s2 = new Series<>(0, x -> x + 2, 10);
		Series<Integer> s3 = new Series<>(1, x -> x + x, x -> x <= 80);
		Series<String> s4 = new Series<>("", s -> s + "*", s -> s.length() <= 10);
		Series<String> s5 = new Series<>("HelloWorld", s -> s.substring(0, s.length() - 1), s -> !s.equals(""));

		while (s1.hasNext()) {
			System.out.print(s1.next() + " ");
		}
		System.out.println();
		s1.reset();

		int i = 1;
		for (Series<?> series : new Series[] { s1, s2, s3, s4, s5 }) {
			System.out.print("s" + (i++) + " = ");
			System.out.println(series.toList());
		}
	}
}
