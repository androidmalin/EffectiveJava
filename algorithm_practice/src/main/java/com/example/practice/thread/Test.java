package com.example.practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);

        //FutureTask被提交给Executor执行以得到返回值
        executor.submit(futureTask);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
        System.out.println();
    }

    private static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3 * 1000);
            int sum = 0;
            for (int i = 1; i <= 100; i++)
                sum += i;
            return sum;
        }
    }
}

