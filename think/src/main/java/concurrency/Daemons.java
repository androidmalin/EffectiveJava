package concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.printnb;

// Daemon threads spawn other daemon threads.
// spawn: 产生
class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }
        for (int i = 0; i < t.length; i++) {
            printnb("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }

        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

public class Daemons {

    /**
     * Daemon线程被设置成了后台模式，然后派生出许多子线程，这些线程并没
     * 有被显式地设置为后台模式，不过它们的确是后台线程。
     * <p>
     * 接着，Daemon线程进入了无限循环，并在循环里调用yield()方法把控制权交给其他进程。
     */
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        // Allow the daemon threads to
        // finish their startup processes:
        TimeUnit.SECONDS.sleep(1);
    }
}
