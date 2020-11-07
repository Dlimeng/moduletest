package com.lm.concurrent.countDownLatch;

import com.lm.concurrent.actuator.ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @Classname CountDownLatchTest
 * @Description TODO
 * @Date 2020/11/4 11:55
 * @Created by limeng
 * 线程池中，join 方法失效，不会退出
 * CountDownLatch 一个线程等待多个线程的场景
 * 实现线程等待
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(()->{
            System.out.println("子线程："+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

       Thread t2 = new Thread(()->{
            System.out.println("子线程："+Thread.currentThread().getName());
            try {
                Thread.sleep(10);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });


        try {
            t1.start();
            t2.start();
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
