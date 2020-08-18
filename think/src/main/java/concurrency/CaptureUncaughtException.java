package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {

    /**
     * 为了解决这个问题，我们要修改Executor产生线程的方式。
     * Thread.UncaughtException—Handler是JavaSE5中的新接囗，
     * 它允许你在每个Thread对象上都附着一个异常处理器。
     * <p>
     * Thread.UncaughtExceptionHandIer.uncaughtException会在线程因未捕获
     * 的异常而临近死亡时被调用。
     * <p>
     * 为了使用它，我们创建了一个新类型的ThreadFactory,
     * 它将在每个新创建的Thread对象上附着一个Thread.UncaughtExceptionHandler
     * 我们将这个工厂传递给Executors创建新的ExecutorService的方法：
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}