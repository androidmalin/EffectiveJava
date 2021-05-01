package com.example.practice.thread;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * https://stackoverflow.com/questions/21300924/difference-between-executors-newfixedthreadpool1-and-executors-newsinglethread
 * https://stackoverflow.com/questions/1960832/the-difference-between-executors-newsinglethreadexecutor-executecommand-and
 */
public class Main {


    /**
     * https://www.cnblogs.com/robothy/p/12121005.html
     * 虽然newSingleThreadExecutor与容量为1的FixedThreadPool的区别只在于一个不可重新配置,一个可重新配置；
     * 但是在按照需求写代码的时候：如果确实要用到容量为1的线程池，应该使用newSingleThreadExecutor而不是用容量为1的FixedThreadPool。
     * <p>
     * 后者有一个隐患，如果开始设置的任务数是1，任务与任务之间本质是串行执行的，
     * 也就是说，一个任务得等到前面一个任务执行结束之后再执行。
     * <p>
     * 而如果后面有人写代码的时候扩大了容量为1的FixedThreadPool，那么修改之前，已经提交的但还未被执行的任务，可能被分到其它线程中去执行。
     * 这样，原本应该串行执行任务变成了并行执行，如果任务之间没有依赖还好，一旦有依赖，逻辑就错乱了。
     * <p>
     * Thread ID:13---> Task1
     * Thread ID:13---> Task2
     * true
     * Thread ID:14---> Task3
     * Thread ID:13---> Task4
     * 下面的实验中，将“等待前面两个任务执行结束”的那行sleep代码注释掉就可以验证这个问题。
     * task1和task2本来是要在1个线程中执行的，而后面由于修改了容量，这两个任务也有一定几率在不同的线程中执行。
     */
    @Test
    public void test_newFixedThreadPool() {
        // 获取一个容量为 1 的 FixedThreadPool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

        // 定义任务组 tasks1
        List<Runnable> tasks1 = Arrays.asList(
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task1");
                },
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task2");
                });

        // 往 FixedThreadPool 中提交 tasks1。此时因为线程池的容量为1，所以两个任务由1个线程执行。
        tasks1.forEach(new Consumer<Runnable>() {
            @Override
            public void accept(Runnable runnable) {
                fixedThreadPool.submit(runnable);
            }
        });

        // 等待前面两个任务结束
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 定义任务组 tasks2
        List<Runnable> tasks2 = Arrays.asList(
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task3");
                },
                () -> {
                    System.out.println("Thread ID:" + Thread.currentThread().getId() + "---> Task4");
                });
        System.out.println(fixedThreadPool instanceof ThreadPoolExecutor); // 输出 true

        // 将 ExecutorService 强转为 ThreadPoolExecutor
        ThreadPoolExecutor configurableFixedThreadPool = (ThreadPoolExecutor) fixedThreadPool;

        // 改变容量
        configurableFixedThreadPool.setCorePoolSize(2);

        // 提交任务组 tasks2。此时由于线程池的容量变成了2，
        // 所以tasks2中的两个任务将分别由不同的线程执行（极端情况下也可能由一个线程执行，但此时线程池容量切切实实变成了2）。
        tasks2.forEach(new Consumer<Runnable>() {
            @Override
            public void accept(Runnable runnable) {
                fixedThreadPool.submit(runnable);
            }
        });
        // 关闭线程池
        fixedThreadPool.shutdown();
        try {
            // 等待任务执行结束
            fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_newFixedThreadPool2() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        System.out.println("------------newFixedThreadPool-------------");
        for (int i = 1; i <= 200; i++) {
            final int index = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    if (index == 20) {
                        throw new IllegalStateException("Error");
                    }
                    System.out.println(Thread.currentThread() + ".." + index);
                }
            });
        }
    }

    @Test
    public void test_newSingleThreadExecutor() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("---------------newSingleThreadExecutor--------------");
        for (int i = 1; i <= 200; i++) {
            newSingleThreadExecutor.execute(new ThreadPoolUtil(i));
        }
    }

    @Test
    public void test_newSingleThreadExecutor2() {
        System.out.println("---------------newSingleThreadExecutor--------------");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("newSingleThreadExecutor instanceof ThreadPoolExecutor=" + (newSingleThreadExecutor instanceof ThreadPoolExecutor));
        for (int i = 1; i <= 200; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    if (index == 20) {
                        throw new IllegalStateException("Error");
                    }
                    System.out.println(Thread.currentThread() + ".." + index);
                }
            });
        }
    }

    public static class ThreadPoolUtil implements Runnable {
        private final Integer index;

        public ThreadPoolUtil(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println(" ");
            System.out.println(index + " 开始处理线程！");
            System.out.println("线程标识是：" + Thread.currentThread().getName());
            System.out.println(index + " 处理结束！");
            System.out.println(" ");
        }
    }
}
