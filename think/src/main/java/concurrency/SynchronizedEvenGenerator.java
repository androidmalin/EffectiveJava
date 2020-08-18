package concurrency;

// Simplifying mutexes with the synchronized keyword.
// {RunByHand}
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); // Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }

    /**
     * 对Thread.yield()的调用被插入到了两个递增操作之间，以提高在
     * currentEvenValue是奇数状态时上下文切换的可能性。
     * <p>
     * 因为互斥可以防止多个任务同时进入临界区，所以这不会产生任何失败。
     * <p>
     * 但是如果失败将会发生，调用yield()是一种促使其发生的有效方式。
     * <p>
     * 第一个进入next()的任务将获得锁，任何其他试图获取锁的任务都将从其
     * 开始尝试之时被阻塞，直至第一个任务释放锁。
     * <p>
     * 通过这种方式，任何时刻只有一个任务可以通过由互斥量看护的代码。
     */
    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
