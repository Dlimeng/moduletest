package com.lm.concurrent.synchronize;

import java.util.concurrent.CountDownLatch;

/**
 *  允许一个或多个线程等待直到在其他线程执行的一组操作完成的
 *  同步辅助
 *
 *
 *  总结：
 *  1.CountDownLatch 和CyclicBarrier能够实现线程之间的等待。
 *  只不过它们侧重点不同：
 *  CountDownLatch 一般用于某个线程A等待若干个其他线程执行完任务之后， 它才执行;
 *  CyclicBarrier 一般用于一组线程互相等待至等待至某个状态，然后这一组线程再同时执行。
 *      CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 *   2.Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 *
 *
 *
 * @Author: limeng
 * @Date: 2019/5/26 16:24
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(){
            @Override
            public void run(){
                System.out.println("线程"+Thread.currentThread().getName()+" 正在执行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+" 执行完毕");
                countDownLatch.countDown();
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("线程"+Thread.currentThread().getName()+" 正在执行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+" 执行完毕");
                countDownLatch.countDown();
            }
        }.start();


        System.out.println("等待2个子线程执行完毕...");
        countDownLatch.await();
        System.out.println("2个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }
}
