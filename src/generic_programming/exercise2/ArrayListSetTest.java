package generic_programming.exercise2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ArrayListSetTest {

	public static final Integer zero = new Integer(0);
	public static final Integer one = new Integer(1);
	public static final Integer two = new Integer(2);
	public static final Integer three = new Integer(3);
	public static final Integer four = new Integer(4);
	public static final Integer five = new Integer(5);
	public static final Integer six = new Integer(6);
	public static final Integer seven = new Integer(7);
	public static final Integer eight = new Integer(8);
	public static final Integer nine = new Integer(9);
	public static final Integer m1 = new Integer(-1);
	public static final Integer m2 = new Integer(-2);
	public static final Integer m3 = new Integer(-3);
	public static final Integer m4 = new Integer(-4);
	public static final Integer m5 = new Integer(-5);
	public static final Integer m6 = new Integer(-6);
	public static final Integer m10 = new Integer(-10);

	/**
	 * The number of elements to place in collections, arrays, etc.
	 */
	static final int SIZE = 20;

	/**
	 * Returns a new set of given size containing consecutive Integers 0 ... n.
	 */
	private ArrayListSet<Integer> populatedSet(int n) {
		ArrayListSet<Integer> q = new ArrayListSet<Integer>();
		assertTrue(q.isEmpty());
		for (int i = n - 1; i >= 0; i -= 2)
			assertTrue(q.add(new Integer(i)));
		for (int i = (n & 1); i < n; i += 2)
			assertTrue(q.add(new Integer(i)));
		assertFalse(q.isEmpty());
		assertEquals(n, q.size());
		return q;
	}

	/**
	 * Returns a new set of first 5 ints.
	 */
	@Test
	public void set5() {
		ArrayListSet<Integer> q = new ArrayListSet<>();
		assertTrue(q.isEmpty());
		q.add(one);
		q.add(two);
		q.add(three);
		q.add(four);
		q.add(five);
		assertEquals(5, q.size());
	}
	
	@Test
	public void testRetainAll() {
		Set<Integer> s1 = new ArrayListSet<>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		Set<Integer> s2 = new ArrayListSet<>();
		s2.add(3);
		s2.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);
		
		s1.retainAll(s2);
		assertTrue(s1.contains(3));
		assertTrue(s1.contains(4));
		assertTrue(s1.contains(5));
		assertFalse(s1.contains(1));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(6));
		assertFalse(s1.contains(7));
	}

	/**
	 * A new set has unbounded capacity
	 */
	@Test
	public void testConstructor1() {
		assertEquals(0, new ArrayListSet<Integer>().size());
	}

	/**
	 * Initializing from null Collection throws NPE
	 */
	@Test
	public void testConstructor3() {
		try {
			new ArrayListSet<Integer>((Collection<Integer>) null);
			Assert.fail();
		} catch (NullPointerException success) {
		}
	}

	/**
	 * Set contains all elements of collection used to initialize
	 */
	@Test
	public void testConstructor6() {
		Integer[] ints = new Integer[SIZE];
		for (int i = 0; i < SIZE; ++i)
			ints[i] = new Integer(i);
		ArrayListSet<Integer> q = new ArrayListSet<>(Arrays.asList(ints));
		for (int i = 0; i < SIZE; ++i)
			assertTrue(q.contains(ints[i]));
	}

	/**
	 * isEmpty is true before add, false after
	 */
	@Test
	public void testEmpty() {
		ArrayListSet<Integer> q = new ArrayListSet<>();
		assertTrue(q.isEmpty());
		q.add(new Integer(1));
		assertFalse(q.isEmpty());
		q.add(new Integer(2));
		q.remove(1);
		q.remove(2);
		assertTrue(q.isEmpty());
	}

	/**
	 * size changes when elements added and removed
	 */
	@Test
	public void testSize() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		for (int i = 0; i < SIZE; ++i) {
			assertEquals(SIZE - i, q.size());
			q.remove(i);
		}
		for (int i = 0; i < SIZE; ++i) {
			assertEquals(i, q.size());
			q.add(new Integer(i));
		}
	}

	/**
	 * add(null) throws NPE if nonempty
	 */
	@Test
	public void testAddNull() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		try {
			q.add(null);
		} catch (NullPointerException success) {
		}
	}

	/**
	 * Add of comparable element succeeds
	 */
	@Test
	public void testAdd() {
		ArrayListSet<Integer> q = new ArrayListSet<>();
		assertTrue(q.add(zero));
		assertTrue(q.add(one));
	}

	/**
	 * Add of duplicate element fails
	 */
	@Test
	public void testAddDup() {
		ArrayListSet<Integer> q = new ArrayListSet<>();
		assertTrue(q.add(zero));
		assertFalse(q.add(zero));
	}

	/**
	 * addAll(null) throws NPE
	 */
	@Test
	public void testAddAll1() {
		ArrayListSet<Integer> q = new ArrayListSet<>();
		try {
			q.addAll(null);
			Assert.fail();
		} catch (NullPointerException success) {
		}
	}

	/**
	 * Set contains all elements of successful addAll
	 */
	@Test
	public void testAddAll5() {
		Integer[] empty = new Integer[0];
		Integer[] ints = new Integer[SIZE];
		for (int i = 0; i < SIZE; ++i)
			ints[i] = new Integer(i);
		ArrayListSet<Integer> q = new ArrayListSet<>();
		assertFalse(q.addAll(Arrays.asList(empty)));
		assertTrue(q.addAll(Arrays.asList(ints)));
		for (int i = 0; i < SIZE; ++i) {
			assertTrue(q.contains(i));
		}
	}

	/**
	 * remove(x) removes x and returns true if present
	 */
	@Test
	public void testRemoveElement() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		for (int i = 1; i < SIZE; i += 2) {
			assertTrue(q.contains(i));
			assertTrue(q.remove(i));
			assertFalse(q.contains(i));
			assertTrue(q.contains(i - 1));
		}
		for (int i = 0; i < SIZE; i += 2) {
			assertTrue(q.contains(i));
			assertTrue(q.remove(i));
			assertFalse(q.contains(i));
			assertFalse(q.remove(i + 1));
			assertFalse(q.contains(i + 1));
		}
		assertTrue(q.isEmpty());
	}

	/**
	 * contains(x) reports true when elements added but not yet removed
	 */
	@Test
	public void testContains() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		for (int i = 0; i < SIZE; ++i) {
			assertTrue(q.contains(new Integer(i)));
			q.remove(new Integer(i));
			assertFalse(q.contains(new Integer(i)));
		}
	}

	/**
	 * clear removes all elements
	 */
	@Test
	public void testClear() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		q.clear();
		assertTrue(q.isEmpty());
		assertEquals(0, q.size());
		q.add(new Integer(1));
		assertFalse(q.isEmpty());
		q.clear();
		assertTrue(q.isEmpty());
	}

	/**
	 * containsAll(c) is true when c contains a subset of elements
	 */
	@Test
	public void testContainsAll() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		ArrayListSet<Integer> p = new ArrayListSet<>();
		for (int i = 0; i < SIZE; ++i) {
			assertTrue(q.containsAll(p));
			assertFalse(p.containsAll(q));
			p.add(new Integer(i));
		}
		assertTrue(p.containsAll(q));
	}

	/**
	 * removeAll(c) removes only those elements of c and reports true if changed
	 */
	@Test
	public void testRemoveAll() {
		for (int i = 1; i < SIZE; ++i) {
			ArrayListSet<Integer> q = populatedSet(SIZE);
			ArrayListSet<Integer> p = populatedSet(i);
			assertTrue(q.removeAll(p));
			assertEquals(SIZE - i, q.size());
		}
	}

	/**
	 * toArray contains all elements in sorted order
	 */
	@Test
	public void testToArray() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		Object[] o = q.toArray();
		for (int i = 0; i < o.length; i++)
			assertTrue(q.contains(o[i]));
	}

	/**
	 * toArray(a) contains all elements in sorted order
	 */
	@Test
	public void testToArray2() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		Integer[] ints = new Integer[SIZE];
		Integer[] array = q.toArray(ints);
		assertSame(ints, array);
		for (int i = 0; i < ints.length; i++)
			assertTrue(q.contains(ints[i]));
	}

	/**
	 * iterator iterates through all elements
	 */
	@Test
	public void testIterator() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		Iterator<Integer> it = q.iterator();
		int i;
		for (i = 0; it.hasNext(); i++)
			assertTrue(q.contains(it.next()));
		assertEquals(i, SIZE);
		// assertIteratorExhausted(it);
	}

	/**
	 * iterator of empty set has no elements
	 */
	@Test
	public void testEmptyIterator() {
		// assertIteratorExhausted(new ArrayListSet().iterator());
	}

	/**
	 * toString contains toStrings of elements
	 */
	@Test
	public void testToString() {
		ArrayListSet<Integer> q = populatedSet(SIZE);
		String s = q.toString();
		for (int i = 0; i < SIZE; ++i) {
			assertTrue(s.contains(String.valueOf(i)));
		}
	}

	Random rnd = new Random(666);
	BitSet bs;

	/**
	 * addAll is idempotent
	 */
	@Test
	public void testAddAll_idempotent() throws Exception {
		Set<Integer> x = populatedSet(SIZE);
		Set<Integer> y = new ArrayListSet<>(x);
		y.addAll(x);
		assertEquals(x, y);
		assertEquals(y, x);
	}

	public void populate(NavigableSet<Integer> set, int limit) {
		for (int i = 0, n = 2 * limit / 3; i < n; i++) {
			int element = rnd.nextInt(limit);
			put(set, element);
		}
	}

	public void mutateSet(NavigableSet<Integer> set, int min, int max) {
		int size = set.size();
		int rangeSize = max - min + 1;

		// Remove a bunch of entries directly
		for (int i = 0, n = rangeSize / 2; i < n; i++) {
			remove(set, min - 5 + rnd.nextInt(rangeSize + 10));
		}

		// Remove a bunch of entries with iterator
		for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
			if (rnd.nextBoolean()) {
				bs.clear(it.next());
				it.remove();
			}
		}

		// Add entries till we're back to original size
		while (set.size() < size) {
			int element = min + rnd.nextInt(rangeSize);
			assertTrue(element >= min && element <= max);
			put(set, element);
		}
	}

	public void mutateSubSet(NavigableSet<Integer> set, int min, int max) {
		int size = set.size();
		int rangeSize = max - min + 1;

		// Remove a bunch of entries directly
		for (int i = 0, n = rangeSize / 2; i < n; i++) {
			remove(set, min - 5 + rnd.nextInt(rangeSize + 10));
		}

		// Remove a bunch of entries with iterator
		for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
			if (rnd.nextBoolean()) {
				bs.clear(it.next());
				it.remove();
			}
		}

		// Add entries till we're back to original size
		while (set.size() < size) {
			int element = min - 5 + rnd.nextInt(rangeSize + 10);
			if (element >= min && element <= max) {
				put(set, element);
			} else {
				try {
					set.add(element);
					Assert.fail();
				} catch (IllegalArgumentException success) {
				}
			}
		}
	}

	public void put(NavigableSet<Integer> set, int element) {
		if (set.add(element))
			bs.set(element);
	}

	public void remove(NavigableSet<Integer> set, int element) {
		if (set.remove(element))
			bs.clear(element);
	}

	public void bashSubSet(NavigableSet<Integer> set, int min, int max, boolean ascending) {
		check(set, min, max, ascending);
		check(set.descendingSet(), min, max, !ascending);

		mutateSubSet(set, min, max);
		check(set, min, max, ascending);
		check(set.descendingSet(), min, max, !ascending);

		// Recurse
		if (max - min < 2)
			return;
		int midPoint = (min + max) / 2;

		// headSet - pick direction and endpoint inclusion randomly
		boolean incl = rnd.nextBoolean();
		NavigableSet<Integer> hm = set.headSet(midPoint, incl);
		if (ascending) {
			if (rnd.nextBoolean())
				bashSubSet(hm, min, midPoint - (incl ? 0 : 1), true);
			else
				bashSubSet(hm.descendingSet(), min, midPoint - (incl ? 0 : 1), false);
		} else {
			if (rnd.nextBoolean())
				bashSubSet(hm, midPoint + (incl ? 0 : 1), max, false);
			else
				bashSubSet(hm.descendingSet(), midPoint + (incl ? 0 : 1), max, true);
		}

		// tailSet - pick direction and endpoint inclusion randomly
		incl = rnd.nextBoolean();
		NavigableSet<Integer> tm = set.tailSet(midPoint, incl);
		if (ascending) {
			if (rnd.nextBoolean())
				bashSubSet(tm, midPoint + (incl ? 0 : 1), max, true);
			else
				bashSubSet(tm.descendingSet(), midPoint + (incl ? 0 : 1), max, false);
		} else {
			if (rnd.nextBoolean()) {
				bashSubSet(tm, min, midPoint - (incl ? 0 : 1), false);
			} else {
				bashSubSet(tm.descendingSet(), min, midPoint - (incl ? 0 : 1), true);
			}
		}

		// subSet - pick direction and endpoint inclusion randomly
		int rangeSize = max - min + 1;
		int[] endpoints = new int[2];
		endpoints[0] = min + rnd.nextInt(rangeSize);
		endpoints[1] = min + rnd.nextInt(rangeSize);
		Arrays.sort(endpoints);
		boolean lowIncl = rnd.nextBoolean();
		boolean highIncl = rnd.nextBoolean();
		if (ascending) {
			NavigableSet<Integer> sm = set.subSet(endpoints[0], lowIncl, endpoints[1], highIncl);
			if (rnd.nextBoolean())
				bashSubSet(sm, endpoints[0] + (lowIncl ? 0 : 1), endpoints[1] - (highIncl ? 0 : 1), true);
			else
				bashSubSet(sm.descendingSet(), endpoints[0] + (lowIncl ? 0 : 1), endpoints[1] - (highIncl ? 0 : 1),
						false);
		} else {
			NavigableSet<Integer> sm = set.subSet(endpoints[1], highIncl, endpoints[0], lowIncl);
			if (rnd.nextBoolean())
				bashSubSet(sm, endpoints[0] + (lowIncl ? 0 : 1), endpoints[1] - (highIncl ? 0 : 1), false);
			else
				bashSubSet(sm.descendingSet(), endpoints[0] + (lowIncl ? 0 : 1), endpoints[1] - (highIncl ? 0 : 1),
						true);
		}
	}

	/**
	 * min and max are both inclusive. If max < min, interval is empty.
	 */
	public void check(NavigableSet<Integer> set, final int min, final int max, final boolean ascending) {
		class ReferenceSet {
			int lower(int element) {
				return ascending ? lowerAscending(element) : higherAscending(element);
			}

			int floor(int element) {
				return ascending ? floorAscending(element) : ceilingAscending(element);
			}

			int ceiling(int element) {
				return ascending ? ceilingAscending(element) : floorAscending(element);
			}

			int higher(int element) {
				return ascending ? higherAscending(element) : lowerAscending(element);
			}

			int first() {
				return ascending ? firstAscending() : lastAscending();
			}

			int last() {
				return ascending ? lastAscending() : firstAscending();
			}

			int lowerAscending(int element) {
				return floorAscending(element - 1);
			}

			int floorAscending(int element) {
				if (element < min)
					return -1;
				else if (element > max)
					element = max;

				// BitSet should support this! Test would run much faster
				while (element >= min) {
					if (bs.get(element))
						return element;
					element--;
				}
				return -1;
			}

			int ceilingAscending(int element) {
				if (element < min)
					element = min;
				else if (element > max)
					return -1;
				int result = bs.nextSetBit(element);
				return (result > max) ? -1 : result;
			}

			int higherAscending(int element) {
				return ceilingAscending(element + 1);
			}

			private int firstAscending() {
				int result = ceilingAscending(min);
				return (result > max) ? -1 : result;
			}

			private int lastAscending() {
				int result = floorAscending(max);
				return (result < min) ? -1 : result;
			}
		}
		ReferenceSet rs = new ReferenceSet();

		// Test contents using containsElement
		int size = 0;
		for (int i = min; i <= max; i++) {
			boolean bsContainsI = bs.get(i);
			assertEquals(bsContainsI, set.contains(i));
			if (bsContainsI)
				size++;
		}
		assertEquals(size, set.size());

		// Test contents using contains elementSet iterator
		int size2 = 0;
		int previousElement = -1;
		for (int element : set) {
			assertTrue(bs.get(element));
			size2++;
			assertTrue(
					previousElement < 0 || (ascending ? element - previousElement > 0 : element - previousElement < 0));
			previousElement = element;
		}
		assertEquals(size2, size);

		// Test navigation ops
		for (int element = min - 1; element <= max + 1; element++) {
			assertEq(set.lower(element), rs.lower(element));
			assertEq(set.floor(element), rs.floor(element));
			assertEq(set.higher(element), rs.higher(element));
			assertEq(set.ceiling(element), rs.ceiling(element));
		}

		// Test extrema
		if (set.size() != 0) {
			assertEq(set.first(), rs.first());
			assertEq(set.last(), rs.last());
		} else {
			assertEq(rs.first(), -1);
			assertEq(rs.last(), -1);
			try {
				set.first();
				Assert.fail();
			} catch (NoSuchElementException success) {
			}
			try {
				set.last();
				Assert.fail();
			} catch (NoSuchElementException success) {
			}
		}
	}

	static void assertEq(Integer i, int j) {
		if (i == null)
			assertEquals(j, -1);
		else
			assertEquals((int) i, j);
	}

	static boolean eq(Integer i, int j) {
		return (i == null) ? j == -1 : i == j;
	}

}
