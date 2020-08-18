package concurrency;

import static net.mindview.util.Print.print;

// Synchronizing on another object.
class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            print("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                print("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {

    /**
     * synchronized块必须给定一个在其上进行同步的对象，并且最合理的方式
     * 是，使用其方法正在被调用的当前对象：synchronized(this)，这正是
     * PairManager2所亻吏用的方式。
     * <p>
     * 在这种方式中，如果获得了synchronized块上的
     * 锁，那么该对象其他的synchronized方法和临界区就不能被调用了。因此，如果
     * 在this上同步，临界区的效果就会直接缩小在同步的范围内。
     * <p>
     * 有时必须在另一个对象上同步，但是如果你要这么做，就必须确保所有相关
     * 的任务都是在同一个对象上同步的。下面的示例演示了两个任务可以同时进入同
     * 一个对象，只要这个对象上的方法是在不同的锁上同步的即可：
     * <p>
     * DualSync.f()（通过同步整个方法）在this同步，而g()有一个在
     * syncObject上同步的synchronized块。因此，这两个同步是互相独立的。通过在
     * main0中创建调用f()的Thread对这一点进行了演示，因为main()线程是
     * 被用来调用g()的。
     * <p>
     * 从输出中可以看到，这两个方式在同时运行，因此任何一个
     * 方法都没有因为对另一个方法的同步而被阻塞。
     */
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
