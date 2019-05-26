package com.lm.concurrent.synchronize.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 假设若干个线程都要进行写数据操作，并且只有所有线程完成写操作之后，这些线程才能继续做后面的事情
 * 1.如果有一个线程没有执行完，报异常，其他线程继续执行后边
 * 2.可重用
 * 3.所有子任务执行完成后，随便选择一个线程完成主任务
 * 此时可以利用CyclicBarrier
 * @Author: limeng
 * @Date: 2019/5/26 16:33
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }

    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(3000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
