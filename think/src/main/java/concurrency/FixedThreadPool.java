package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    /**
     * 有了FixedThreadPool,你就可以一次性预先执行代价高昂的线程分配，
     * 因而也就可以限制线程的数量了。
     * <p>
     * 这可以节省时间，因为你不用为每个任务都固定地付出创建线程的开销。
     * <p>
     * 在事件驱动的系统中，需要线程的事件处理器，通过直接从池中获取线程，也可以如你所愿地尽快得到服务。
     * <p>
     * 你不会滥用可获得的资源，因为FixedThreadPool使用的Thread对象的数量是有界的。
     * <p>
     * 注意，在任何线程池中，现有线程在可能的情况下，都会被自动复用。
     * <p>
     * 尽管本书将使用CachedThreadPool,但是也应该考虑在产生线程的代码中使用FixedThreadPoll.
     * <p>
     * CachedThreadPool在程序执行过程中通常会创建与所需数量相同的线程，
     * 然后在它回收旧线程时停止创建新线程，因此它是合理的Executor的首选。
     * <p>
     * 只有当这种方式会引发问题时，你才需要切换到FixedThreadPool。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        // Constructor argument is number of threads:
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
