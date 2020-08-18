package concurrency;

// A Runnable containing its own driver Thread.
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    /**
     * 这与从Thread继承并没有什么特别的差异，只是语法稍微晦涩一些。
     * <p>
     * 但是，实现接囗使得你可以继承另一个不同的类，而从Thread继承将不行。
     * <p>
     * 注意，start()是在构造器中调用的。
     * <p>
     * 这个示例相当简单，因此可能是安全的，但是你应该意识到，在构造器中启动线程可能会变得很有问题，
     * 因为另一个任务可能会在构造器结束之前开始执行，这意味着该任务能够访问处于不稳定状态的对象。
     * <p>
     * 这是优选Executor而不是显式地创建Thread对象的另一个原因。
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
