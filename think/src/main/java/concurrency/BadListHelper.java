package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.cnblogs.com/yaowen/p/5983136.html
 */
class BadListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }
}

/**
 * @ThreadSafe class GoodListHelper <E> {
 * public List<E> list = Collections.synchronizedList(new ArrayList<E>());
 * <p>
 * public boolean putIfAbsent(E x) {
 * synchronized (list) {
 * boolean absent = !list.contains(x);
 * if (absent)
 * list.add(x);
 * return absent;
 * }
 * }
 * }
 * 如果你要分析这个实现是否正确，你需要搞清楚Collections.synchronizedList返回的线程安全的List内部使用的锁是哪个对象，
 * 所以你得看看Collections.synchronizedList这个方法的源码了。该方法源码如下：
 * <p>
 * public static <T> List<T> synchronizedList(List<T> list) {
 * return (list instanceof RandomAccess ?
 * new SynchronizedRandomAccessList<T>(list) :
 * new SynchronizedList<T>(list));
 * }
 * <p>
 * 通过源码，我们还需要知道ArrayList是否实现了RandomAccess接口：
 * <p>
 * public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
 * <p>
 * 查看ArrayList的源码，可以看到它实现了RandomAccess，所以上面的synchronizedList返回的应该是SynchronizedRandomAccessList的实例。
 * <p>
 * 接下来看看SynchronizedRandomAccessList这个类的实现：
 * <p>
 * static class SynchronizedRandomAccessList<E>  extends SynchronizedList<E>  implements RandomAccess {
 * SynchronizedRandomAccessList(List<E> list) {
 * super(list);
 * }
 * SynchronizedRandomAccessList(List<E> list, Object mutex) {
 * super(list, mutex);
 * }
 * public List<E> subList(int fromIndex, int toIndex) {
 * synchronized(mutex) {
 * return new SynchronizedRandomAccessList<E>(
 * list.subList(fromIndex, toIndex), mutex);
 * }
 * }
 * static final long serialVersionUID = 1530674583602358482L;
 * private Object writeReplace() {
 * return new SynchronizedList<E>(list);
 * }
 * }
 * 因为SynchronizedRandomAccessList这个类继承自SynchronizedList，而大部分方法都在SynchronizedList中实现了，
 * 所以源码中只包含了很少的方法，但是通过subList方法，我们可以看到这里使用的锁对象为mutex对象，
 * <p>
 * 而mutex是在SynchronizedCollection类中定义的，所以再看看SynchronizedCollection这个类中关于mutex的定义部分源码：
 * <p>
 * static class SynchronizedCollection<E> implements Collection<E>, Serializable {
 * private static final long serialVersionUID = 3053995032091335093L;
 * final Collection<E> c;  // Backing Collection
 * final Object mutex;     // Object on which to synchronize
 * <p>
 * SynchronizedCollection(Collection<E> c) {
 * if (c==null)
 * throw new NullPointerException();
 * this.c = c;
 * mutex = this;
 * }
 * <p>
 * SynchronizedCollection(Collection<E> c, Object mutex) {
 * this.c = c;
 * this.mutex = mutex;
 * }
 * }
 * 可以看到mutex就是当前的SynchronizedCollection对象，
 * <p>
 * <p>
 * SynchronizedRandomAccessList==>SynchronizedList==>SynchronizedCollection
 * <p>
 * 而SynchronizedRandomAccessList继承自SynchronizedList，SynchronizedList又继承自SynchronizedCollection，
 * <p>
 * 所以SynchronizedRandomAccessList中的mutex也就是SynchronizedRandomAccessList的this对象。
 * <p>
 * 所以在GoodListHelper中使用的锁list对象，和SynchronizedRandomAccessList内部的锁是一致的，所以它可以实现线程安全性。
 */
class GoodListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}