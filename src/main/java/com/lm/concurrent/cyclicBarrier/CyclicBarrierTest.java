package com.lm.concurrent.cyclicBarrier;

import com.lm.concurrent.actuator.ThreadPool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname CyclicBarrierTest
 * @Description TODO
 * @Date 2020/11/7 15:13
 * @Created by limeng
 * 解决一组线程之间互相等待
 * 让一组线程等待至某个状态之后再全部同步执行，叫做回环是因为当所有等待线程都被释放以后，CycilcBarrier可以被重用，我们暂且把这个状态叫做barrier
 * ，当调用await()方法之后，线程就处于barrier了。
 *
 *
 * parties 聚集数量，保证同步回调函数的数量
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int N = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        ThreadPoolExecutor pool = ThreadPool.newFixedThreadPool(10, "CyclicBarrierTest", false);

        System.out.println(cyclicBarrier.getParties());

        for (int i = 0; i < N; i++) {
            pool.execute(new Writer(cyclicBarrier));
        }


    }

    static class Writer implements Runnable{
        private  CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程："+Thread.currentThread().getName()+" 正在写入数据");
            try {
                Thread.sleep(1000);
                System.out.println("线程："+Thread.currentThread().getName() + "写完");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务");
        }
    }

}
