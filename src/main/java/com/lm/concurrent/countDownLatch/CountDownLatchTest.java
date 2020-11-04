package com.lm.concurrent.countDownLatch;

import com.lm.concurrent.actuator.ThreadPool;

import java.util.concurrent.ExecutorService;

/**
 * @Classname CountDownLatchTest
 * @Description TODO
 * @Date 2020/11/4 11:55
 * @Created by limeng
 * 线程池中，join 方法失效，不会退出
 * CountDownLatch 一个线程等待多个线程的场景
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService pool = ThreadPool.newFixedThreadPool(5, "FutureTest", false);




        pool.shutdown();
    }

    /**
     * 订单库
     */
    static class Order{

    }

    /**
     * 派送单库
     */
    static class Deliver{

    }

}
