package com.lm.concurrent.future;

import com.lm.concurrent.actuator.ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * @Classname FutureTest2
 * @Description TODO
 * @Date 2020/11/4 11:42
 * @Created by limeng
 * FutureTask 实现了Runnable 和 Future接口
 */
public class FutureTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = ThreadPool.newFixedThreadPool(5, "FutureTest", false);

        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);

        pool.submit(futureTask);

        System.out.println(futureTask.get());
    }
}


