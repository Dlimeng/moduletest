package com.lm.concurrent.completionservice;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Classname CompletionServiceTest
 * @Description TODO
 * @Date 2020/12/29 20:44
 * @Created by limeng
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(service);
        for (int i = 0; i < 100; i++) {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    int sleepValue = new Random().nextInt(5);
                    System.out.println("sleep = " + sleepValue + ", name: " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(sleepValue);
                    return "huhx: " + sleepValue + ", " + Thread.currentThread().getName();
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(completionService.take().get());
        }
        service.shutdown();
    }
}
