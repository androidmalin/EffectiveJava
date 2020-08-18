package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    /**
     * 但是，该程序将找到奇数值并终止。
     * <p>
     * 尽管return确实是原子性操作，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取。
     * 除此之外，由于i也不是volatile的，因此还存在可视性问题。
     * <p>
     * getValue()和evenIncrement()必须是synchronized的。
     * <p>
     * 在诸如此类情况下，只有并发专家才有能力进行优化，而你还是应该运用Brian的同步规则。
     * <p>
     * Brian的同步规则:
     * 如果你正在写一个变量，它可能接下来将被另一个线程读取，
     * 或者正在读取一个上一次已经被另一个线程写过的变量，
     * 那么你必须使用同步，并且，读写线程都必须用相同的监视器锁同步。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}