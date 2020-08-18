package concurrency;

// Demonstration of the Runnable interface.
public class LiftOff implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    /**
     * 如果知道已经完成了在run()方法的循环的一次迭代过程中所需的工作，
     * 就可以给线程调度机制一个暗示：你的工作已经做得差不多了，可以让别的线程使
     * 用CPU了。
     * <p>
     * 这个暗示将通过调用yield()方法来作出（不过这只是一个暗示，没有任何机制保证它将会被采纳）。
     * <p>
     * 当调用yield()时，你也是在建议具有相同优先级的其他线程可以运行。
     * <p>
     * LiftOff.java使用yield()在各种不同的LiftOff任务之间产生分布良好的处理
     * 机制。尝试着注释掉LiftOff.run()中的Thread.yield()，以查看区别。
     * <p>
     * 但是，大体上，对于任何重要的控制或在调整应用时，都不能依赖于yield()。
     * 实际上，yield()经常被误用。
     */
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
