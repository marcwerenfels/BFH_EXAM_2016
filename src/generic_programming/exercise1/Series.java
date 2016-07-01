package generic_programming.exercise1;

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

}
