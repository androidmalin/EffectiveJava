package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Shows the use of thread priorities.
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d; // No optimization
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            // An expensive, interruptable operation:
            for (int i = 1; i < 100_000_000L; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    /**
     * 线程的优先级将该线程的重要性传递给了调度器。
     * <p>
     * 尽管CPU处理现有线程集的顺序是不确定的，但是调度器将倾向于让优先权最高的线程先执行。
     * <p>
     * 然而，这并不正意味着优先权较低的线程将得不到执行（也就是说，优先权不会导致死锁）。
     * <p>
     * 优先级较低的线程仅仅是执行的频率较低。
     * 在绝大多数时间里，所有线程都应该以默认的优先级运行。试图操纵线程优先级通常是一种错误。
     * <p>
     * 下面是一个演示优先级等级的示例，你可以用getPriority()来读取现有线
     * 程的优先级，并且在任何时刻都可以通过setPriority()来修改它。
     * <p>
     * <p>
     * toString()方法被覆盖，以便使用Thread.toString()方法来打印线程的
     * 名称、线程的优先级以及线程所属的"线程组"。
     * <p>
     * 你可以通过构造器来自己设置这个名称；这里是自动生成的名称，如pool-l-thread-l，pool-1-thread-2等。
     * <p>
     * 覆盖后的toString()方法还打印了线程的倒计数值。
     * <p>
     * 注意，你可以在一个任务的内部，通过调用Thread.CurrentThread()来获得对驱动该任务的Thread对象的引用。
     * <p>
     * 可以看到，最后一个线程的优先级最高，其余所有线程的优先级被设为最低。
     * <p>
     * 注意，优先级是在run()的开头部分设定的，在构造器中设置它们不会有任何好处，
     * 因为Executor在此刻还没有开始执行任务。
     * <p>
     * <p>
     * 在run()里，执行了100000次开销相当大的浮点运算，包括double类型的加法与除法。
     * <p>
     * 变量d是volatile的，以努力确保不进行任何编译器优化。
     * <p>
     * 如果没有加入这些运算的话，就看不到设置优先级的效果（试一试：把包含double运算的for循环注释掉）。
     * <p>
     * 有了这些运算，就能观察到优先级为MAX_PRIORITY的线程被线程调度器优先选择（至少在我的WindowsXP机器上是这样）。
     * <p>
     * 尽管向控制台打印也是开销较大的操作，但在那种情况下看不出优先级的效果，因为向控制台打
     * 印不能被中断（否则的话，在多线程情况下控制台显示就乱套了），而数学运算是可以中断的。
     * <p>
     * <p>
     * 这里运算时间足够的长，因此线程调度机制才来得及介入，交换任务并关注优先级，使得最高优先级线程被优先选择。
     * <p>
     * 尽管JDK有10个优先级，但它与多数操作系统都不能映射得很好。
     * <p>
     * 比如，Windows有7个优先级且不是固定的，所以这种映射关系也是不确定的。Sun的Solaris有2^31个优先级。
     * <p>
     * 唯一可移植的方法是当调整优先级的时候，只使用MAX_PRIORITY、NORM_PRIORITY和MIN_PRIORITY三种级别。
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

/* Output: (70% match)
Thread[pool-1-thread-6,10,main]: 5
Thread[pool-1-thread-6,10,main]: 4
Thread[pool-1-thread-6,10,main]: 3
Thread[pool-1-thread-6,10,main]: 2
Thread[pool-1-thread-6,10,main]: 1
Thread[pool-1-thread-3,1,main]: 5
Thread[pool-1-thread-2,1,main]: 5
Thread[pool-1-thread-1,1,main]: 5
Thread[pool-1-thread-5,1,main]: 5
Thread[pool-1-thread-4,1,main]: 5
...
*/
