package generic_programming.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparablePairTester {

	public static void main(String[] args) {
		ComparablePair<Integer,String> p1 = new ComparablePair<>(3, "Hello");
		ComparablePair<Integer,String> p2 = new ComparablePair<>(3, "World");
		ComparablePair<Integer,String> p3 = new ComparablePair<>(2, "Hello");
		ComparablePair<Integer,String> p4 = new ComparablePair<>(2, "World");
		ComparablePair<Integer,String> p5 = new ComparablePair<>(4, "Hello");
		ComparablePair<Integer,String> p6 = new ComparablePair<>(4, "World");

		System.out.println(ComparablePair.getMin(p1, p2));
		System.out.println(ComparablePair.getMax(p1, p2));
		
		List<ComparablePair<?, ?>> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		//Collections.sort(list);
		System.out.println(list);
	}

}
