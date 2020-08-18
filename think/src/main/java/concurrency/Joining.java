package concurrency;

import static net.mindview.util.Print.print;

// Understanding join().
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        print(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " join completed");
    }
}

public class Joining {

    /**
     * 一个线程可以在其他线程之上调用join()方法，其效果是等待一段时间直到
     * 第二个线程结束才继续执行。
     * <p>
     * 如果某个线程在另一个线程t上调用t.join()，此线程将被挂起，直到目标线程t结束才恢复
     * （即t.isAlive()返回为假）。
     * <p>
     * 也可以在调用join()时带上一个超时参数（单位可以是毫秒，或者毫秒和纳秒），
     * 这样如果目标线程在这段时间到期时还没有结束的话，join()方法总能返回。
     * <p>
     * 对join()方法的调用可以被中断，做法是在调用线程上调用interrupt()方法，这时需要用到try一catch子句。
     * 下面这个例子演示了所有这些操作：
     * <p>
     * <p>
     * Sleeper是一个Thread类型，它要休眠一段时间，这段时间是通过构造器传进来的参数所指定的。
     * <p>
     * 在run()中，sleep()方法有可能在指定的时间期满时返回，但也可能被中断。
     * <p>
     * 在catch子句中，将根据isInterrupted()的返回值报告这个中断。
     * <p>
     * 当另一个线程在该线程上调用interrupt()时，将给该线程设定一个标志，表明该线程已经被中断。
     * <p>
     * <p>
     * 然而，异常被捕获时将清理这个标志，所以在catch子句中，在异常被捕获的时候这个标志总是为假。
     * <p>
     * 除异常之外，这个标志还可用于其他情况，比如线程可能会检查其中断状态.
     * <p>
     * Joiner线程将通过在Sleeper对象上调用join()方法来等待Sleeper醒来。
     * <p>
     * 在main()里面，每个Sleeper都有一个Joiner,这可以在输出中发现，
     * 如果Sleeper被中断或者是正常结束，Joiner将和Sleeper一同结束。
     * <p>
     * 注意，JavaSE5的java.util.concurrent类库包含诸如CyclicBarrier（本章稍
     * 后会展示）这样的工具，它们可能比最初的线程类库中的join()更加适合。
     */
    public static void main(String[] args) {
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
