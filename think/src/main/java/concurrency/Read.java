package concurrency;

public class Read {

    /**
     * 正如前面各节所示，在Java中，你可以选择如何实现并发编程，并且这个选择会令人困惑。
     * <p>
     * 这个问题通常来自于用来描述并发程序技术的术语，特别是涉及线程的那些。
     * <p>
     * 到目前为止，你应该看到要执行的任务与驱动它的线程之间有一个差异，
     * 这个差异在Java类库中尤为明显，因为你对Thread类实际没有任何控制权
     * （并且这种隔离在使用执行器时更加明显，因为执行器将替你处理线程的创建和管理）
     * 你创建任务，并通过某种方式将一个线程附着到任务上，以使得这个线程可以驱动任务。
     * <p>
     * 在Java中，Thread类自身不执行任何操作，它只是驱动赋予它的任务，
     * 但是线程研究中总是不变地使用"线程执行这项或那项动作"这样的语言。
     * <p>
     * 因此，你得到的印象就是"线程就是任务"，当我第一次碰到Java线程时，
     * 这种印象非常强烈，以至于我看到了一种明显的"是一个"关系，
     * <p>
     * 这就像是在说，很明显我应该从Thread继承出一个任务。
     * <p>
     * 另外，Runnable接囗的名字选择很糟糕，所以我认为Task应该是好得多名字。
     * <p>
     * 如果接口只是其方法的返型封装，那么"它执行能做的事情"这种命名方式将是恰当的，
     * 但是如果它是要表示更高层的抽象，例如Task,那么概念名将有用。
     * <p>
     * 问题是各种抽象级别被混在了一起。
     * <p>
     * 从概念上讲，我们希望创建独立于其他任务运行的任务，因此我们应该能够定义任务，
     * 然后说"开始"，并且不用操心其细节。
     * <p>
     * 但是在物理上，创建线程可能会代价高昂，因此你必须保存并管理它们。
     * 这样，从实现的角度看，将任务从线程中分离出来是很有意义的。
     * <p>
     * 另外，Java的线程机制基于来自C的低级的p线程方式，这是一种你必须深入研究，
     * 并且需要须完全理解其所有事物的所有细节的方式。
     * <p>
     * 这种低级特性部分地渗入了Java的实现中，
     * <p>
     * 因此为了处于更高的抽象级别，在编写代码时，你必须遵循规则（我将在本章中努力演示这些规则）
     * <p>
     * 为了澄清这些讨论，我将尝试着在描述将要执行的工作时使用术语"任务"
     * <p>
     * 只有在我引用到驱动任务的具体机制时，才使用"线程"。
     * <p>
     * 因此，如果你在概念级别上讨论系统，那就可以只使用"任务"，而压根不需要提及驱动机制。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {

    }
}