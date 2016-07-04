package generic_programming.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Box<T> {

	private static final Map<Object, Box<?>> INSTANCES = new HashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> Box<T> getInstance(T content) {
		if (INSTANCES.containsKey(content)) {
			return (Box<T>) INSTANCES.get(content);
		} else {
			Box<T> newInstance = new Box<>(content);
			INSTANCES.put(content, newInstance);
			return newInstance;
		}
	}

	private T content;

	private Box(T content) {
		this.content = content;
	}

	public T getContent() {
		return this.content;
	}

	public static void main(String[] args) {

		Box<String> b1 = Box.getInstance("Hello");
		Box<String> b2 = Box.getInstance("Hello");
		Box<String> b3 = Box.getInstance("World");

		System.out.println(b1 == b2); // returns true
		System.out.println(b1 == b3); // returns false
		System.out.println(b2 == b3); // returns false
	}
}