package com.lm.concurrent.future;

import com.lm.concurrent.actuator.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Classname FutureTest3
 * @Description TODO
 * @Date 2020/11/4 11:48
 * @Created by limeng
 */
public class FutureTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = ThreadPool.newFixedThreadPool(5, "FutureTest", false);

        Future<String> futureTask = pool.submit(new CallableTest());

        System.out.println(futureTask.get());
    }

    static class CallableTest implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "test";
        }
    }

}
