package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    /**
     * SingleThreadExecutor就像是线程数量为1的FixedThreadPool。
     * <p>
     * 这对于你希望在另一个线程中连续运行的任何事物（长期存活的任务）来说，都是很有用的，
     * <p>
     * 例如监听进入的套接字连接的任务。
     * <p>
     * 它对于希望在线程中运行的短任务也同样很方便，例如，更新本地或远程日志的小任务，或者是事件分发线程。
     * <p>
     * 如果向SingleThreadExecutor提交了多个任务，那么这些任务将排队，
     * 每个任务都会在下一个任务开始之前运行结束，所有的任务将使用相同的线程。
     * <p>
     * 在下面的示例中，你可以看到每个任务都是按照它们被提交的顺序，并且是在下一个任务开始之前完成的。
     * <p>
     * 因此 SingleThreadExecutor 会序列化所有提交给它的任务，并会维护它自己（隐藏）的悬挂任务队列。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
