package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// Preventing thread collisions with mutexes.
// {RunByHand}
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield(); // Cause failure faster
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 使用显式的Lock对象
     * <p>
     * JavaSE5的java.util.concurrent类库还包含有定义在
     * java.util.concurrent.locks.Lock中的显式的互斥机制。
     * <p>
     * Lock对象必须被显式地创建、锁定和释放。
     * <p>
     * 因此，它与内建的锁形式相比，代码缺乏优雅性。
     * <p>
     * 但是，对于解决某些类型的问题来说，它更加灵活。下面用显式的Lock重写的是
     * <p>
     * <p>
     * MutexEvenGenerator添加了一个被互斥调用的锁，并使用lock()和unlock()方法在next()内部创建了临界资源。
     * <p>
     * 当你在使用Lock对象时，将这里所示的惯用法内部化是很重要的：
     * <p>
     * 紧接着的对lock()的调用，你必须放置在finally子
     * 句中带有unlock()的try-catch语句中。
     * <p>
     * 注意，return语句必须在try子句中出现，以确保unlock()不会过早发生，
     * 从而将数据暴露给了第二个任务。
     * <p>
     * 尽管try-finally所需的代码比synchronized关键字要多，但是这也代表了显式
     * 的Lock对象的优点之一。
     * <p>
     * 如果在使用synchronized关键字时，某些事物失败了，那么就会抛出一个异常。
     * 但是你没有机会去做任何清理工作，以维护系统使其处于良好状态。
     * <p>
     * 有了显式的Lock对象，你就可以使用finally子句将系统维护在正确的状态了。
     * <p>
     * <p>
     * 大体上，当你使用synchronized关键字时，需要写的代码量更少，并且用户
     * 错误出现的可能性也会降低，因此通常只有在解决特殊问题时，才使用显式的
     * Lock对象。
     * <p>
     * 例如，用synchronized关键字不能尝试着获取锁且最终获取锁会失
     * 败，或者尝试着获取锁一段时间，然后放弃它，要实现这些，你必须使用
     * concurrent类库：
     */
    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
