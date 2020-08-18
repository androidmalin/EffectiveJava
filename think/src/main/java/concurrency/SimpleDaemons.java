package concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

// Daemon threads don't prevent the program from ending.
public class SimpleDaemons implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    /**
     * 所谓后台(daemon)线程，是指在程序运行的时候在后台提供一种通用服务的线程，
     * 并且这种线程并不属于程序中不可或缺的部分。
     * <p>
     * 因此，当所有的非后台线程结束时，程序也就终止了，同时会杀死进程中的所有后台线程。
     * <p>
     * 反过来说，只要有任何非后台线程还在运行，程序就不会终止。
     * 比如，执行main()的就是一个非后台线程。
     * <p>
     * 必须在线程启动之前调用setDaemon()方法，才能把它设置为后台线程。
     * 一旦main()完成其工作，就没什么能阻止程序终止了，因为除了后台线程
     * 之外，已经没有线程在运行了。
     * <p>
     * <p>
     * main()线程被设定为短暂睡眠，所以可以观察到所有后台线程启动后的结果。
     * <p>
     * 不这样的话，你就只能看见一些后台线程创建时
     * 得到的结果（试试调整sleep()休眠的时间，以观察这个行为）
     * <p>
     * SimpleDaemons.java创建了显式的线程，以便可以设置它们的后台标志。
     * 通过编写定制的ThreadFactory可以定制由Executor创建的线程的属性（后台、优先级、名称）
     */
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
} /* Output: (Sample)
All daemons started
Thread[Thread-0,5,main] SimpleDaemons@530daa
Thread[Thread-1,5,main] SimpleDaemons@a62fc3
Thread[Thread-2,5,main] SimpleDaemons@89ae9e
Thread[Thread-3,5,main] SimpleDaemons@1270b73
Thread[Thread-4,5,main] SimpleDaemons@60aeb0
Thread[Thread-5,5,main] SimpleDaemons@16caf43
Thread[Thread-6,5,main] SimpleDaemons@66848c
Thread[Thread-7,5,main] SimpleDaemons@8813f2
Thread[Thread-8,5,main] SimpleDaemons@1d58aae
Thread[Thread-9,5,main] SimpleDaemons@83cc67
...
*///:~
