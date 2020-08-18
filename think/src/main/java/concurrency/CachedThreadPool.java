package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    /**
     * JavaSE5的java.util.concurrent包中的执行器(Executor)将为你管理Thread对象，从而简化了并发编程。
     * <p>
     * Executor在客户端和任务执行之间提供了一个间接层；与客户端直接执行任务不同，这个中介对象将执行任务。
     * <p>
     * Executor允许你管理异步任务的执行，而无须显式地管理线程的生命周期。
     * <p>
     * Executor在JavaSE5/6中是启动任务的优选方法。
     * <p>
     * 我们可以使用Executor来代替在MoreBasicThreads.java中显示地创建Thread对象。
     * <p>
     * LiftOff对象知道如何运行具体的任务，与命令设计模式一样，它暴露了要执行的单一方法。
     * <p>
     * ExecutorService（具有服务生命周期的Executor，例如关闭）
     * 知道如何构建恰当的上下文来执行Runnable对象。
     * <p>
     * 在下面的示例中，CachedThreadPool将为每个任务都创建一个线程。
     * <p>
     * 注意，ExecutorService对象是使用静态的Executor方法创建的，这个方法可以确定其Executor类型：
     * <p>
     * <p>
     * 非常常见的情况是，单个的Executor被用来创建和管理系统中所有的任务。
     * <p>
     * 对shutdown()方法的调用可以防止新任务被提交给这个Executor，
     * 当前线程（在本例中，即驱动main()的线程）将继续运行在shutdown()被调用之前提交的所有任务。
     * <p>
     * 这个程序将在Executor中的所有任务完成之后尽快退出。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
