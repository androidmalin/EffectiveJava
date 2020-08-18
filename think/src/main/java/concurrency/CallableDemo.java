package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * {@link java.util.concurrent.Callable}接口类似于{@link java.lang.Runnable}，
 * 两者都是针对类的实例可能由另一个线程执行的类而设计的。
 * <p>
 * 但是，{@code Runnable}不会返回结果，因此无法抛出一个检查异常。
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {

    /**
     * 21.2.4从任务中产生返回值
     * <p>
     * Runnable是执行工作的独立任务，但是它不返回任何值。
     * <p>
     * 如果你希望任务在完成时能够返回一个值，那么可以实现Callable接囗而不是Runnable接囗。
     * <p>
     * 在
     * JavaSE5中引入的v是一种具有类型参数的泛型，它的类型参数表示的是
     * 从方法call()（而不是run()）中返回的值，并且必须使用
     * ExecutorService.submit()方法调用它，
     * <p>
     * 下面是一个简单示例：
     * <p>
     * <p>
     * submit()方法会产生Future对象，它用Callable返回结果的特定类型进行了参数化。
     * <p>
     * 你可以用isDone()方法来查询Future是否已经完成。
     * <p>
     * 当任务完成时，它具有一个结果，你可以调用get()方法来获取该结果。
     * <p>
     * 你也可以不用isDone()进行检查就直接调用get()，在这种情况下，get()将阻塞，直至结果准备就绪。
     * <p>
     * 你还可以在试图调用get()来获取结果之前，先调用具有超时的get()，或者调用isDone()来查看任务是否完成。
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results) {
            try {
                // get() blocks until completion:
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                return;
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            } finally {
                exec.shutdown();
            }
        }
    }
}
