package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// Locks in the concurrent library allow you
// to give up on trying to acquire a lock.
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("untimed tryLock(): " + captured);
        } finally {
            if (captured) {
                System.out.println("untimed unlock() ");
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("timed tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                System.out.println("timed unlock() ");
                lock.unlock();
            }
        }
    }

    /**
     * ReentrantLock允许你尝试着获取但最终未获取锁，这样如果其他人已经获取了这个锁，
     * 那你就可以决定离开去执行其他一些事情，而不是等待直至这个锁被释放，
     * 就像在untimed()方法中所看到的。
     * <p>
     * 在timed()中，做出了尝试去获取锁，该尝试可以在2秒之后失败
     * （注意，使用了JavaSE5的TimeUnit类来指定时间单位）。
     * <p>
     * 在main()中，作为匿名类而创建了一个单独的Thread，它将获取锁，
     * 这使得untimed()和timed()方法对某些事物将产生竞争。
     * <p>
     * 显式的Lock对象在加锁和释放锁方面，相对于内建的synchronized锁来说，
     * 还赋予了你更细粒度的控制力。
     * <p>
     * 这对于实现专有同步结构是很有用的，
     * 例如用于遍历链接列表中的节点的节节传递的加锁机制（也称为锁耦合），
     * 这种遍历代码必须在释放当前节点的锁之前捕获下一个节点的锁。
     */
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed();   // True -- lock is available
        // Now create a separate task to grab the lock:
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield(); // Give the 2nd task a chance
        al.untimed(); // False -- lock grabbed by task
        al.timed();   // False -- lock grabbed by task
    }
}
