package generic_programming.exercise2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ArrayListSet<T> implements Set<T> {

    private ArrayList<T> list;

    public ArrayListSet() {
        this.list = new ArrayList<>();
    }

    public ArrayListSet(Collection<? extends T> collection) {
        this.list = new ArrayList<>();
        for (T element : collection) {
            this.add(element);
        }
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        if (this.list.contains(t)) {
            return false;
        } else {
            return this.list.add(t);
        }
    }

    @Override
    public boolean remove(Object o) {
        return this.list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        for (T element: c) {
            result = result | this.add(element);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.list.removeAll(c);
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        ArrayListSet<T> other = (ArrayListSet<T>) obj;
        return this.list.containsAll(other.list) && other.list.containsAll(this.list);
    }

    @Override
    public String toString() {
        return "ArrayListSet " + list;
    }
}
