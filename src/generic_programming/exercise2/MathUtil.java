package generic_programming.exercise2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MathUtil {

	private static final int CERTAINTY = 80;
	private static final Set<BigInteger> PRIMES = new HashSet<>();
	private static final Set<BigInteger> COMPOSITES = new HashSet<>();
	private static final List<Integer> FIBS = new ArrayList<>(Arrays.asList(0, 1));

	public static boolean isPrime(BigInteger p) {
		if (PRIMES.contains(p)) {
			return true;
		}
		if (COMPOSITES.contains(p)) {
			return false;
		}
		boolean result = p.isProbablePrime(CERTAINTY);
		if (result) {
			PRIMES.add(p);
		} else {
			COMPOSITES.add(p);
		}
		return result;
	}

	public static int fibonacci(int x) {
		if (x < FIBS.size()) {
			return FIBS.get(x);
		}
		int result = fibonacci(x - 1) + fibonacci(x - 2);
		FIBS.add(result);
		return result;
	}
	
	public static int unchachedFibonacci(int x) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		return unchachedFibonacci(x-1) + unchachedFibonacci(x-2);
	}


	public static void main(String[] args) {
		
		// test isPrime
		int tests = 5000000;
		BigInteger p = new BigInteger("123456789");
		for (int i = 1; i < tests; i++) {
			p.isProbablePrime(CERTAINTY);
		}
		System.out.println("Done");
		for (int i = 1; i < tests; i++) {
			isPrime(p);
		}
		System.out.println("Done");

		// test fibonacci
		System.out.println(unchachedFibonacci(45));
		System.out.println(fibonacci(45));
	}
}
