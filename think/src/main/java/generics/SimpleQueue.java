package generics;


import java.util.Iterator;
import java.util.LinkedList;

// A different kind of container that is Iterable
public class SimpleQueue<T> implements Iterable<T> {

    private LinkedList<T> storage = new LinkedList<>();

    public void add(T t) {
        storage.offer(t);
    }

    public T get() {
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
